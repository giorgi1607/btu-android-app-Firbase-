package com.example.btuapp.Anouncmantfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Adapters.anounc_writen_recycleradapter
import com.example.btuapp.Adapters.loadingfragment
import com.example.btuapp.R
import com.example.btuapp.writing_anouncmant_activity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.example.btuapp.Models.user_written_anounces_modal
import com.example.btuapp.detailedactivityes.detailed_writtenanouncmant_activity
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface

class write_anouncmant_fragment :Fragment(),onitemclicklistenerinterface {
    var modaldata=ArrayList<user_written_anounces_modal>()
   var recycler =anounc_writen_recycleradapter( modaldata,this)
    private   var  uid= FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?,savedInstanceState: Bundle?   ): View? {
        var view : View = LayoutInflater.from(context).inflate(R.layout.anouncwrite_fragment,container,false)




        var fab =view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
            var intent :Intent = Intent (context, writing_anouncmant_activity::class.java)
            startActivity(intent)
        }


            var referenc=FirebaseDatabase.getInstance().getReference("BTU").child("users_anouncmants")
                .child(uid!!)

        referenc.addChildEventListener(object :ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                var  modal = user_written_anounces_modal()
                var retriavedmodal= snapshot.getValue( modal.javaClass)
                if (retriavedmodal != null) {
                    modaldata.add(retriavedmodal)
                }

                recycler.notifyDataSetChanged()




            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

                var  modal = user_written_anounces_modal()
                var retriavedmodal= snapshot.getValue( modal.javaClass)
                if (retriavedmodal != null) {
                    modaldata.add(retriavedmodal)
                }

                recycler.notifyDataSetChanged()





            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                modaldata.clear()
                var  modal = user_written_anounces_modal()
                var retriavedmodal= snapshot.getValue( modal.javaClass)
                if (retriavedmodal != null) {
                    modaldata.add(retriavedmodal)
                }

                recycler.notifyDataSetChanged()



            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                recycler.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                recycler.notifyDataSetChanged()
            }


        })





            var recyclerxml=view.findViewById<RecyclerView>(R.id.written_recyclerview)








        var Layoutmanager= LinearLayoutManager(context)
        recyclerxml.layoutManager=Layoutmanager
        recyclerxml.adapter=recycler


        return view
    }

    override fun onitemclick(position: Int) {

        var title=modaldata[position].title
        var description=modaldata[position].description
        var date=modaldata[position].time_written



        var intent =Intent(context, detailed_writtenanouncmant_activity::class.java)
        intent.putExtra("atitle",title)
        intent.putExtra("adescription",description)
        intent.putExtra("date",date)
        startActivity(intent)



    }


}