package com.example.btuapp.Adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class authviewpager(app: AppCompatActivity, var list :ArrayList<Fragment>) : FragmentStateAdapter(app)  {
    override fun getItemCount(): Int {

        return list.size
    }

    override fun createFragment(position: Int): Fragment {
       return list[position]
    }
}