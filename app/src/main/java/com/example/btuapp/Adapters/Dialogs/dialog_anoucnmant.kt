package com.example.btuapp.Adapters.Dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.btuapp.Models.user_written_anounces_modal
import com.example.btuapp.R
import com.example.btuapp.interfacecallbacks.activityfinish
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class dialog_anoucnmant (var spinnerdata :String, var anoucmantdata :String,var activitycontext:activityfinish) :  DialogFragment(){
    var  dbreference= FirebaseDatabase.getInstance().getReference("BTU").child("users_anouncmants")
    private   var  uid= FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view =LayoutInflater.from(context).inflate(R.layout.dialog_anouncmant,null)
        var dialogaccceptbtn=view.findViewById<Button>(R.id.dialogaccpetbtn)
        var dismissbtn=view.findViewById<Button>(R.id.dialogdismissbtn)


        dialogaccceptbtn.setOnClickListener {

            val sdf = SimpleDateFormat("dd.MM.yyyy")
            val currentDate = sdf.format(Date()).toString()
            var dateString = "$currentDate"
            var modal= user_written_anounces_modal(spinnerdata,anoucmantdata,dateString)

            dbreference.child(uid.toString()).push().setValue(modal)

            activitycontext.activityfinishinterface()

        }
        dismissbtn.setOnClickListener {
            this.dismiss()
        }








        return  view
    }





}