package com.example.btuapp.detailedactivityes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.btuapp.R

class detailed_anouncmant_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_anouncmant_activity)


        var tb = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar3 )
        setSupportActionBar(tb)
        supportActionBar?.setTitle("BTU განცხადებები")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var stringdata=intent?.extras?.get("data").toString()
        var passeddescription=intent.extras?.get("description")
        var passeddtitle=intent.extras?.get("title")
            var anoucnmanttitle:TextView=findViewById(R.id.anountitle)
        var anouncmantdescription:TextView=findViewById(R.id.anouncdescription)

        anoucnmanttitle.text=passeddtitle.toString()
        anouncmantdescription.text=passeddescription.toString()


    }
}