package com.example.btuapp.detailedactivityes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Adapters.detailed_grades_recyclerview
import com.example.btuapp.Models.courseitemmodal
import com.example.btuapp.R

class detailed_grades_activity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.detailed_grades_activity)
            var tb = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar5)
            setSupportActionBar(tb)


            supportActionBar?.setDisplayHomeAsUpEnabled(true)


             var gmail_intent_button=findViewById<ImageButton>(R.id.gmail_intent_button)

            var  passedcoursename = intent.extras?.get("coursename")
            var  passedlectorname = intent.extras?.get("lectorname")
            var  passedactivities = intent.extras?.get("activities")

            var passedhomework=intent.extras?.get("homeworkarray")
            var passedpointarray=intent.extras?.get("homeworkpoint")





            supportActionBar?.setTitle("$passedcoursename ")
            gmail_intent_button.setOnClickListener {
                var intent =packageManager.getLaunchIntentForPackage("com.google.android.gm")
                startActivity(intent)



            }





            var recyclerxml:RecyclerView=findViewById(R.id.detailed_grades_recyclerview)
            var layoutmanager=LinearLayoutManager(this)
            recyclerxml.layoutManager=layoutmanager

            var adapter = detailed_grades_recyclerview(passedhomework as ArrayList<String>,
                passedpointarray as ArrayList<String>
            )
            recyclerxml.adapter=adapter


            var lector:TextView=findViewById(R.id.lectorname)

            lector.text="ლექტორი "+passedlectorname .toString()








        }
}