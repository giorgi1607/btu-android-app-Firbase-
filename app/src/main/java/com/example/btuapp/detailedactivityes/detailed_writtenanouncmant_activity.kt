package com.example.btuapp.detailedactivityes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.btuapp.R

class detailed_writtenanouncmant_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_writtenanouncmant_activity)

        var tb =findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar4)
        setSupportActionBar(tb)
        supportActionBar?.setTitle("ჩემი განცხადებები")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


         var  title :TextView=findViewById(R.id.atitle)
        var description :TextView=findViewById(R.id.adescription)
        var adate:TextView=findViewById(R.id.adate)
        var passedtitle=intent.extras?.get("atitle")
        var passeddescription=intent.extras?.get("adescription")
        var passeddate=intent.extras?.get("date")
        title.text=passedtitle.toString()
        description.text=passeddescription.toString()
        adate.text=passeddate.toString()

    }
}