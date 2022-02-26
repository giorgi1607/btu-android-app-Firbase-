package com.example.btuapp.MainFragments

import android.app.Notification
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.Builder
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btuapp.Adapters.gradesrecyclerview
import com.example.btuapp.Adapters.loadingfragment
import com.example.btuapp.Models.courseitemmodal
import com.example.btuapp.R
import com.example.btuapp.detailedactivityes.detailed_grades_activity
import com.example.btuapp.interfacecallbacks.onitemclicklistenerinterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class grades_fragment : Fragment() , onitemclicklistenerinterface {

    var data=ArrayList<courseitemmodal>()
    var  radapter= gradesrecyclerview(data,this)
    private  lateinit var dbreference: DatabaseReference
    private   var auth = FirebaseAuth.getInstance()



private var loadingview=loadingfragment()


    fun fetchdate(){

        fragmentManager?.let { loadingview.show(it,"tag") }
        dbreference= FirebaseDatabase.getInstance().getReference("users")
        var currentuser= dbreference.child(auth.currentUser?.uid!!).child("courses")


        currentuser.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(snapshot: DataSnapshot) {
                data.clear()

                    for(i in snapshot.children){

                     var modal=courseitemmodal()

                        modal.lector= i.child("lector").value.toString()
                        modal.coursename=i.key.toString()



                              for(c in i.child("activities").children){



                                    modal.all_point_sum+=Integer.parseInt(c.value.toString())

                                  modal.homework.add(c.key.toString())
                                  modal.homework_point.add(c.value.toString())


                              }


                        data.add(modal)



                    }





                    radapter.notifyDataSetChanged()
                loadingview.dismiss()

            }

            override fun onCancelled(error: DatabaseError) {
                println("dwd")
            }


        })


    }







    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view :View =LayoutInflater.from(context).inflate(R.layout.grades_fragment_layout,container,false)


        fetchdate()
        var recyclerxml=view.findViewById<RecyclerView>(R.id.grades_recyclerview)
        var manager=LinearLayoutManager(context)
        recyclerxml.layoutManager=manager
        recyclerxml.adapter=radapter
        return view
    }

    override fun  onitemclick(position: Int) {
        var intent : Intent =Intent(context,detailed_grades_activity::class.java)
        var coursename=data[position].coursename
        var lectorname=data[position].lector
        var pointsum=data[position].all_point_sum


        var homeworkarray=data[position].homework
        var homeworkpoint=data[position].homework_point

        intent.putExtra("pointsum",pointsum)



           intent.putExtra("coursename","${coursename }")
        intent.putExtra("lectorname","${ lectorname }")



        intent.putExtra("homeworkarray",homeworkarray)
        intent.putExtra("homeworkpoint",homeworkpoint)


        startActivity(intent)



    }





















}

