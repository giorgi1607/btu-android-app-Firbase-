package com.example.btuapp.MainFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.btuapp.Adapters.Dialogs.phone_change_dialog
import com.example.btuapp.Adapters.Dialogs.photo_change_dialog
import com.example.btuapp.Models.userinfo
import com.example.btuapp.R
import com.example.btuapp.auth_activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class profile_fragments: Fragment() {






    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View =LayoutInflater.from(context).inflate(R.layout.profile_fragment_layout,container,false)

        var user_name_field :TextView=view.findViewById(R.id.user_name_field)
        var user_email_field:TextView=view.findViewById(R.id.user_email_field)
        var user_faculty_field:TextView=view.findViewById(R.id.user_faculty_field)
        var user_phone_number:TextView=view.findViewById(R.id.user_phone_number)
        var phone_changer_btn:ImageButton=view.findViewById(R.id.phone_chunger_btn)
        var changedialog=phone_change_dialog()
        var profile_image:ImageView=view.findViewById(R.id.user_profile_image)
      var Photo_changer_iconbutton:ImageButton=view.findViewById(R.id.photochangericon)
        var photochangerdialog=photo_change_dialog()


        if(FirebaseAuth.getInstance().currentUser!=null) {

            var userid = FirebaseAuth.getInstance().currentUser?.uid
            var instance =
                FirebaseDatabase.getInstance().getReference("users").child(userid.toString())
                    .child("user_personal_data")



            instance.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var modal = snapshot.getValue(userinfo::class.java)
                    user_name_field.text=modal?.name.toString()+" " +modal?.surname.toString()
                    user_email_field.text= modal?.email.toString()

                    user_faculty_field.text=modal?.faculty.toString()

                    context?.let {
                        Glide.with(it)
                            .load(modal?.image.toString())
                            .placeholder(R.drawable.ic_baseline_person_24)
                            .error(R.drawable.ic_baseline_no_photography_24)
                            .centerCrop()
                            .into(profile_image)
                    };

                        user_phone_number.text=modal?.phone.toString()










                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })





        }










        phone_changer_btn.setOnClickListener {

            fragmentManager?.let { it1 -> changedialog.show(it1,"dwdw") }



        }


        Photo_changer_iconbutton.setOnClickListener {
            fragmentManager?.let { it1 -> photochangerdialog.show(it1,"Dwd") }


        }




        return view
    }



}