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

class success_dialog :DialogFragment() {
        private lateinit var dialog_register_btn_succes:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view:View=LayoutInflater.from(context).inflate(R.layout.succes_dialog_layout,null)
        dialog_register_btn_succes=view.findViewById(R.id.dialog_register_btn_succes)


        dialog_register_btn_succes.setOnClickListener {
            dismiss()

            startActivity(Intent(context,auth_activity::class.java))


        }





        return view
    }
}