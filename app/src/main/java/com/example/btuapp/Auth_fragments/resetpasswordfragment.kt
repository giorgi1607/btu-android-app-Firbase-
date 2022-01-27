package com.example.btuapp.Auth_fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.btuapp.R
import com.google.firebase.auth.FirebaseAuth

class resetpasswordfragment : DialogFragment() {
private lateinit var emailreset:EditText
private lateinit var resetbtn :Button
private lateinit var exitbtn:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            var view :View=LayoutInflater.from(context).inflate(R.layout.reset_password_dialog,null)
        emailreset=view.findViewById(R.id.retetemailfioeld)
        resetbtn=view.findViewById(R.id.ressetpaswordbtn)
        exitbtn=view.findViewById(R.id.resetexitbtn)

        resetbtn.setOnClickListener {
            var emailtext=emailreset.text.toString()
            if(!emailtext.isEmpty() && emailtext.contains("@")  &&  emailtext.contains(".") ){

                FirebaseAuth.getInstance().sendPasswordResetEmail(emailtext).addOnCompleteListener { it ->
                    if(it.isSuccessful){
                        dismiss()
                        Toast.makeText(context,"გთხოვთ გადაამოწმოთ ელ-ფოსტა და მიჰყვეთ ინსტრუქციებს",Toast.LENGTH_LONG).show()

                    }
                        else{
                            Toast.makeText(context," დაფიქსირდა შეცდომა ",Toast.LENGTH_LONG).show() }

                }

            }else{
                Toast.makeText(context,"  გთხოვთ გადაამოწმოთ შეყვანილი ინფორმაცია ",Toast.LENGTH_LONG).show()


            }






        }
        exitbtn.setOnClickListener {
            dismiss()

        }










        return view
    }



}