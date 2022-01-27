package com.example.btuapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Models.courseitemmodal
import com.example.btuapp.R

class detailed_grades_recyclerview (var homeworkarray:ArrayList<String>,var pointarray:ArrayList<String>):RecyclerView.Adapter<detailed_grades_recyclerview.myholder>(){

    class myholder(itemView: View) :RecyclerView.ViewHolder(itemView){
       var homeworktitle:TextView=itemView.findViewById(R.id.homeworktitile)
        var homeworkpoint:TextView=itemView.findViewById(R.id.homeworkpoint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myholder {
            var view =LayoutInflater.from(parent.context).inflate(R.layout.detailed_activities_item,null)

            var holder =myholder(view)
        return holder


    }

    override fun onBindViewHolder(holder: myholder, position: Int) {
            holder.homeworktitle.text=homeworkarray[position]
        holder.homeworkpoint.text=pointarray[position]

    }

    override fun getItemCount(): Int {

        return homeworkarray.size

    }


}