package com.example.btuapp.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Models.btuanouncmantmodal
import com.example.btuapp.R
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

class btuanouncmantrecyclerview(var data:ArrayList<btuanouncmantmodal>, var itemclick:onitemclicklistenerinterface) :RecyclerView.Adapter<btuanouncmantrecyclerview.myhodler> (){

    class myhodler(itemView: View,var itemclick:onitemclicklistenerinterface) :RecyclerView.ViewHolder(itemView){


            var title :TextView =itemView.findViewById(R.id.anouncmanttitle)


        init {
            itemView.setOnClickListener {
                itemclick.onitemclick(adapterPosition)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myhodler {
        var view :View =LayoutInflater.from(parent.context).inflate(R.layout.btuanouncmantrecyclerview_layout,null)

        var holder =myhodler(view,itemclick)
        return holder
    }

    override fun onBindViewHolder(holder: myhodler, position: Int) {
         holder.title.text=data[position].anoucnmant_title


    }

    override fun getItemCount(): Int {
        return  data.size
    }









}