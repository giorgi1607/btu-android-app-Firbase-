package com.example.btuapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.btuapp.Adapters.Dialogs.logoutdialog
import com.example.btuapp.Models.userinfo
import com.example.btuapp.interfacecallbacks.activityfinish
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() ,activityfinish{
    lateinit  var drawerLayout :DrawerLayout
    lateinit  var navcontroller: NavController
    lateinit  var bottomNavigationView:BottomNavigationView
    lateinit  var configuration:AppBarConfiguration

lateinit var navigation_view:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout=findViewById(R.id.drawerlayout)
        var tb=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)

       navcontroller =findNavController(R.id.fragmenthoster)
        bottomNavigationView =findViewById(R.id.bottomnavigationview)
         configuration= AppBarConfiguration(setOf(R.id.grades_fragment,R.id.message_fragment,R.id.anouncmant_fragment),drawerLayout,)
        bottomNavigationView.setupWithNavController(navcontroller)
        tb.setupWithNavController(navcontroller,configuration)
        navigation_view=findViewById(R.id.navigation_view)
        var logout=logoutdialog(this)

        navigation_view.setNavigationItemSelectedListener {

            if(it.itemId ==R.id.logoutbtn){ logout.show(supportFragmentManager,"Dw") ;}
            true

        }
            var header=navigation_view.getHeaderView(0)

       var   header_username= header.findViewById<TextView>(R.id.header_user_name)
        var header_picture=header.findViewById<ImageView>(R.id.header_picture)
        var reference=FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().currentUser?.uid!!).child("user_personal_data")

        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                 var useriinfo =snapshot.getValue(userinfo::class.java)
                    var emial=useriinfo?.email.toString()
                header_username.text="${emial}"


                    Glide.with(applicationContext)
                        .load(useriinfo?.image.toString())
                        .placeholder(R.drawable.ic_baseline_person_24)
                        .error(R.drawable.ic_baseline_no_photography_24)
                        .centerCrop()
                        .into(header_picture)



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }



    override fun activityfinishinterface() {
         finish()
    }


}