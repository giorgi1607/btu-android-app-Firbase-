package com.example.btuapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Models.user_written_anounces_modal
import com.example.btuapp.R
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface
import org.w3c.dom.Text

class anounc_writen_recycleradapter(var data:ArrayList<user_written_anounces_modal>,var click :onitemclicklistenerinterface) : RecyclerView.Adapter<anounc_writen_recycleradapter.myholder> (){

    class myholder(itemView: View,var click :onitemclicklistenerinterface) : RecyclerView.ViewHolder(itemView)   {
        var anounctitle=itemView.findViewById<TextView>(R.id.anounctitle)
        var anouncdate=itemView.findViewById<TextView>(R.id.anouncdate)

                init {
                    itemView.setOnClickListener {
                        click.onitemclick(adapterPosition)

                    }
                }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myholder {
         var view :View =LayoutInflater.from(parent.context).inflate(R.layout.anouncmant_item_recyclerview,null)

        var holder =myholder(view,click)

        return  holder


    }

    override fun onBindViewHolder(holder:  myholder, position: Int) {
      holder.anounctitle.text=data.get(position).title
        holder.anouncdate.text=data.get(position).time_written



    }

    override fun getItemCount(): Int {
        return data.size
    }


}