package com.example.btuapp.Adapters.Dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.btuapp.R
import com.example.btuapp.auth_activity
import com.example.btuapp.interfacecallbacks.activityfinish
import com.google.firebase.auth.FirebaseAuth

class logoutdialog(var  activityfinish: activityfinish) : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.dialog_logout,null)

        var yesbtn=view.findViewById<Button>(R.id.logoutyesbtn)
        var nobtn=view.findViewById<Button>(R.id.logoutnobtn)



        yesbtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context,auth_activity::class.java))
            activityfinish.activityfinishinterface()
            this.dismiss()


        }
        nobtn.setOnClickListener {

            this.dismiss()

        }





        return  view
    }




}