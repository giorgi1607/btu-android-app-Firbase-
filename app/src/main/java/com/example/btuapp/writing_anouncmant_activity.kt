package com.example.btuapp

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.btuapp.Adapters.Dialogs.dialog_anoucnmant
import com.example.btuapp.Adapters.Dialogs.exit_dialog_anoucnmant
import com.example.btuapp.Models.user_written_anounces_modal
import com.example.btuapp.interfacecallbacks.activityfinish
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatterBuilder
import java.util.*

class writing_anouncmant_activity : AppCompatActivity() , activityfinish {

private   var  uid=FirebaseAuth.getInstance().currentUser?.uid
   lateinit  var dialogfragment :dialog_anoucnmant
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_anouncmant)

        var tb =findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar2)
        setSupportActionBar(tb)
        supportActionBar?.setTitle("განცხადების შევსება")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
            var exitbtn:Button=findViewById(R.id.exitbtn)

        var  dbreference= FirebaseDatabase.getInstance().getReference("BTU").child("users_anouncmants")





        exitbtn.setOnClickListener {

            var exitdialog= exit_dialog_anoucnmant(this)
            exitdialog.show(supportFragmentManager,"Dwad")




        }
        var publishbtn:Button=findViewById(R.id.publishbtn)



        var userinput:EditText=findViewById(R.id.anoucnmant_written_text)
        var spinner:Spinner=findViewById(R.id.anoucnmant_spinner)
        publishbtn.setOnClickListener {




                var userinputedtext=userinput.text.toString()
                var spinnertext=spinner.selectedItem.toString()








          dialogfragment=dialog_anoucnmant(spinnertext,userinputedtext,this)
            dialogfragment.show(supportFragmentManager,"dwad")
    }















    }

    override fun activityfinishinterface() {
         this.finish()
    }
}