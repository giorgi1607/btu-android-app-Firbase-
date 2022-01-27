package com.example.btuapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Models.courseitemmodal
import com.example.btuapp.R
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface

class gradesrecyclerview (var data : ArrayList<courseitemmodal> , var courseclicklistener:onitemclicklistenerinterface) :RecyclerView.Adapter<gradesrecyclerview.myholder>(){




    class myholder(itemView: View,var  courseclicklistener :onitemclicklistenerinterface) :RecyclerView.ViewHolder(itemView){
        var  coursename=itemView.findViewById<TextView>(R.id.coursetitle)
        var  point =itemView.findViewById<TextView>(R.id.pointstitle)

        init {
            itemView.setOnClickListener{
                courseclicklistener.onitemclick(adapterPosition)
            }



        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):myholder  {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.grades_recyclerview_layout,null)
        var holder =myholder(view,courseclicklistener)
        return holder
    }

    override fun onBindViewHolder(holder: myholder, position: Int) {
         holder.coursename.text=data[position].coursename.toString()
        holder.point.text=data[position].all_point_sum.toString()


    }

    override fun getItemCount(): Int {
       return data.size
    }


}