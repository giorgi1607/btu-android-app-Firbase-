package com.example.btuapp.Anouncmantfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Adapters.btuanouncmantrecyclerview
import com.example.btuapp.Adapters.loadingfragment
import com.example.btuapp.Models.btuanouncmantmodal
import com.example.btuapp.R
import com.example.btuapp.detailedactivityes.detailed_anouncmant_activity
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class btu_anouncmant_list :Fragment()  ,onitemclicklistenerinterface{
    private  lateinit var dbreference:DatabaseReference
    private   var auth = FirebaseAuth.getInstance()
 private var data = ArrayList<btuanouncmantmodal>()
    private var loadingview= loadingfragment()
    var recycler=btuanouncmantrecyclerview( data,this)
    fun fetchdate(){
        dbreference= FirebaseDatabase.getInstance().getReference("BTU").child("Anouncmants")
        Log.d("anouncmant", "${ dbreference}")
        fragmentManager?.let { loadingview.show(it,"tagawd") }

        dbreference.addValueEventListener(object : ValueEventListener {



            override fun onDataChange(snapshot: DataSnapshot) {


                for (i in snapshot.children){
                        var btuanouncmantmodal= btuanouncmantmodal()
                    btuanouncmantmodal.anoucnmant_title=i.key.toString()
                    btuanouncmantmodal.anouncmant_description=i.value.toString()

                   data.add(btuanouncmantmodal)
                    recycler.notifyDataSetChanged()
                    loadingview.dismiss()
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }











    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        var view :View=LayoutInflater.from(context).inflate(R.layout.anouncbtu_fragment,container,false)
        fetchdate()

            var recyclerxml =view.findViewById<RecyclerView>(R.id.btuanouncrecycler)
        var layoutmanager=LinearLayoutManager(context)
        recyclerxml.layoutManager=layoutmanager
        recyclerxml.adapter=recycler

        return view
    }

    override fun onitemclick(position: Int) {

        var description=data[position].anouncmant_description.toString()
        var title =data[position].anoucnmant_title.toString()

        var intent : Intent = Intent(context, detailed_anouncmant_activity::class.java)
       intent.putExtra("description", description)
        intent.putExtra("title", title)
        startActivity(intent)
    }


}