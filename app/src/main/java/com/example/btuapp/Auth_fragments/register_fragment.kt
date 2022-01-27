package com.example.btuapp.Auth_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.btuapp.Adapters.Dialogs.success_dialog
import com.example.btuapp.Models.userinfo
import com.example.btuapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class register_fragment : Fragment() {
    lateinit var  inputemail: EditText

    lateinit var inputepassword1: EditText
    lateinit var inputepassword2: EditText
    lateinit var registerbtn: Button
        lateinit var namefield:EditText
        lateinit var surnmaefield:EditText
        lateinit var coursespinner:Spinner
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view =LayoutInflater.from(context).inflate(R.layout.activity_registeractivty,null)
        inputemail=view.findViewById(R.id.inputedemail)
        inputepassword1=view.findViewById(R.id.inputepassword1)
        inputepassword2=view.findViewById(R.id.inputepassword2)
        registerbtn=view.findViewById(R.id.registerbtn)
        namefield=view.findViewById(R.id.register_usernamefield)
        surnmaefield=view.findViewById(R.id.register_usersurnmaefield)
        coursespinner=view.findViewById(R.id.register_spinner)



        var success_dialog_fragment= success_dialog()

        registerbtn.setOnClickListener {

            var nametext=namefield.text.toString()
            var  surnametext= surnmaefield.text.toString()
            var spinnertext=coursespinner.selectedItem.toString()
            var  emailtext=inputemail.text.toString()
            var password1text=inputepassword1.text.toString()
            var password2text=inputepassword2.text.toString()

            if(nametext.isEmpty()){
                namefield.setError(" შეავსეთ  ველი !")
            }
            if(surnametext.isEmpty()){
                surnmaefield.setError(" შეავსეთ  ველი !")
            }

            if(emailtext.isEmpty()){
                inputemail.setError(" შეავსეთ იმეილის ველი !")
            }
            if (!emailtext.contains("@") ||  !emailtext.contains(".") ){
                inputemail.setError(" გთხოვთ  შეიყვანოთ ვალიდური იმეილი !")
            }
            if(password1text.isEmpty()){
                inputepassword1.setError("შეავსეთ ეს ველი ")

            }
            if(password1text.length<8){
                inputepassword1.setError(" პაროლი უნდა შეიცავდეს მინიმუმ 8 სიმბოლოს ")

            }
            if(password2text.isEmpty()){
                inputepassword2.setError("შეავსეთ ეს ველი ")

            }
            if(password2text.length<8){
                inputepassword2.setError("პაროლი უნდა შეიცავდეს მინიმუმ 8 სიმბოლოს  ")

            }
            if( password1text!=password2text){
                inputepassword2.setError("პაროლები არ ემთხვევა ერთმანეთს")


            }

            if(!emailtext.isEmpty() && emailtext.contains("@") &&  emailtext.contains(".")  &&
                !password1text.isEmpty() &&
                !password2text.isEmpty() &&
                password1text.length>=8 &&
                password1text==password2text  && !nametext.isEmpty() && !surnametext.isEmpty() ){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailtext,password1text).addOnCompleteListener{
                        task-> if(task.isSuccessful){

                    if(FirebaseAuth.getInstance().currentUser!=null){

                        var userid=FirebaseAuth.getInstance().currentUser?.uid


                        if (userid != null) {
                            FirebaseDatabase.getInstance().getReference("users").child(userid)
                        }

                        FirebaseDatabase.getInstance().getReference("users").
                        child(userid.toString()).child("courses")
                        var modall = userinfo()
                        modall.faculty=spinnertext
                        modall.name=nametext
                        modall.surname= surnametext
                        modall.email= FirebaseAuth.getInstance().currentUser?.email.toString()


                        FirebaseDatabase.getInstance().getReference("users").child("$userid").child("user_personal_data").setValue(modall)




                    }



                    fragmentManager?.let { it1 -> success_dialog_fragment.show(it1,"DW") }



                }else{
                    Toast.makeText(context,"Error while registering,try another email address ", Toast.LENGTH_SHORT).show()

                }
                }




            }














        }















        return  view
    }



}