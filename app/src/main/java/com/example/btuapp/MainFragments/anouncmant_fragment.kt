package com.example.btuapp.MainFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.btuapp.Adapters.viewpageradapter
import com.example.btuapp.Anouncmantfragment.btu_anouncmant_list
import com.example.btuapp.Anouncmantfragment.write_anouncmant_fragment
import com.example.btuapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class anouncmant_fragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View =
            LayoutInflater.from(context).inflate(R.layout.anouncmant_fragment_layout,container,false)





        var btuanoucfragment=btu_anouncmant_list()
        var writeAnouncmantFragment=write_anouncmant_fragment()
        var data=ArrayList<Fragment>()
        data.add(btuanoucfragment)
        data.add(writeAnouncmantFragment)
        var viewpagerxml=view.findViewById<ViewPager2>(R.id.viewpager)
         var tablayout = view.findViewById<TabLayout>(R.id.tablayout)


        var viewpager=viewpageradapter(context as AppCompatActivity, data)
        viewpagerxml.adapter=viewpager
        TabLayoutMediator(tablayout,viewpagerxml){
            tab,position->   if(position==0){
                tab.text="Btu განცხადებები"
            }
            if(position==1){
            tab.text="განცხადების დაწერა "
            }


        }.attach()



        return view
    }
}