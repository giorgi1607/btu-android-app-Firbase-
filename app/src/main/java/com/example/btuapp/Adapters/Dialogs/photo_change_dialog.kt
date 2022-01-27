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

class photo_change_dialog :DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view:View=LayoutInflater.from(context).inflate(R.layout.dialog_profile_image_changer,null)
        var exitbtn=view.findViewById<Button>(R.id.exitphotochangerbtn)
        var changebtn=view.findViewById<Button>(R.id.photochangerbtn)
var image_link_edittext=view.findViewById<EditText>(R.id.image_link_edittext)



        exitbtn.setOnClickListener {
            dismiss()
        }


        changebtn.setOnClickListener {
            var image_link= image_link_edittext.text.toString()

            if(FirebaseAuth.getInstance().currentUser!=null){

                var userid= FirebaseAuth.getInstance().currentUser?.uid
                var instance=
                    FirebaseDatabase.getInstance().getReference("users").child(userid.toString()).child("user_personal_data").child("image")





                    if (!image_link.isEmpty()) {



                        instance.setValue( image_link)

                        dismiss()


                    } else {
                        Toast.makeText(context, "ველი ცარიელია ", Toast.LENGTH_SHORT).show()
                    }
                }













        }










        return view
    }








}