package com.example.btuapp.Adapters.Dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.btuapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class phone_change_dialog : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=LayoutInflater.from(context).inflate(R.layout.phone_change_layout,null)

        var inputednumber=view.findViewById<EditText>(R.id.editTextPhone)
        var changebtn=view.findViewById<Button>(R.id.changebtn)
        var exitbtn=view.findViewById<Button>(R.id.quitebtnnum)

        if(FirebaseAuth.getInstance().currentUser!=null){

        var userid=FirebaseAuth.getInstance().currentUser?.uid
        var instance=FirebaseDatabase.getInstance().getReference("users").child(userid.toString()).child("user_personal_data").child("phone")


        exitbtn.setOnClickListener {
            dismiss()
        }

        changebtn.setOnClickListener {

            var numberdata = inputednumber.text.toString()

            if (!numberdata.isEmpty()) {



                instance.setValue(numberdata)
                Toast.makeText(context, " ნომერი შეიცვალა  წარმატებით", Toast.LENGTH_SHORT).show()
                dismiss()


            } else {
                Toast.makeText(context, "ველი ცარიელია ", Toast.LENGTH_SHORT).show()
            }
        }



    }



        return view
    }



}