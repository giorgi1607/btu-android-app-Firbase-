package com.example.btuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.btuapp.Adapters.authviewpager
import com.example.btuapp.Auth_fragments.login_fragmnet
import com.example.btuapp.Auth_fragments.register_fragment
import com.example.btuapp.Models.userinfo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class auth_activity : AppCompatActivity() {













    private lateinit var tablayout:TabLayout
    private lateinit var viewpagerxml :ViewPager2

    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser!=null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        tablayout=findViewById(R.id.authttablayout)
        viewpagerxml=findViewById(R.id.authviewpager)
        var loginfragment=login_fragmnet()
        var registerfragment=register_fragment()
        var fragmentarray=ArrayList<Fragment>()
        fragmentarray.add(loginfragment)
        fragmentarray.add(registerfragment)
       var viewpager=  authviewpager(this,fragmentarray)
        viewpagerxml.adapter=viewpager
        TabLayoutMediator(tablayout,viewpagerxml){
                tab,position->   if(position==0){
            tab.text="სისტემაში შესვლა"
        }
            if(position==1){
                tab.text="რეგისტრაცია"
            }
        }.attach()





    }
}