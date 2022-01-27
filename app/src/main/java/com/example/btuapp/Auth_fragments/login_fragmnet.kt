package com.example.btuapp.Auth_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.btuapp.MainActivity
import com.example.btuapp.R
import com.google.firebase.auth.FirebaseAuth

class login_fragmnet : Fragment() {
    lateinit var inputemailfieldforlogin: EditText
    lateinit var inputepasswordfieldforlogin: EditText
    lateinit var loginbtn: Button
    lateinit var recoverbtn:Button
var  resetfragment=resetpasswordfragment()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         var view =LayoutInflater.from(context).inflate(R.layout.activity_log_in,null)


        inputemailfieldforlogin=view.findViewById(R.id. inputemailfieldforlogin)
        inputepasswordfieldforlogin=view.findViewById(R.id.inputepasswordfieldforlogin)
        loginbtn=view.findViewById(R.id.loginbtn)
    recoverbtn=view.findViewById(R.id.recoverbtn)

        recoverbtn.setOnClickListener {
            fragmentManager?.let { it1 -> resetfragment.show(it1,"Dw") }


        }







        loginbtn.setOnClickListener {

            var emailtext = inputemailfieldforlogin.text.toString()
            var passwordtext = inputepasswordfieldforlogin.text.toString()
            if (emailtext.isEmpty()) {
                inputemailfieldforlogin.setError("გთხოვთ შეავსოთ ეს ველი")

            }
            if (passwordtext.isEmpty()) {
                inputepasswordfieldforlogin.setError("გთხოვთ შეავსოთ ეს ველი")

            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailtext, passwordtext)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            var intent: Intent = Intent(context, MainActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(
                                context, "User not found or Inputed field are wrong ",
                                Toast.LENGTH_SHORT
                            ).show() } } }  }









        return view


}}