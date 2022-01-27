package com.example.btuapp.Adapters.Dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.btuapp.MainActivity
import com.example.btuapp.R
import com.example.btuapp.interfacecallbacks.activityfinish

class exit_dialog_anoucnmant(var activitydismiss :activityfinish) : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =LayoutInflater.from(context).inflate(R.layout.exit_dialog_fragment,null)
        var dismisbtn=view.findViewById<Button>(R.id.dismissdialogdeslinebtn)
        var acceptbtn=view.findViewById<Button>(R.id.dismissdialogaccpetbtn)

        dismisbtn.setOnClickListener {
            this.dismiss()

        }
        acceptbtn.setOnClickListener {
            Toast.makeText(context,"განცხადების დაწერა გაუქმებულია",Toast.LENGTH_SHORT).show()
            activitydismiss.activityfinishinterface()
            this.dismiss()

        }






        return view
    }



}