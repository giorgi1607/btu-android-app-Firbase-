package com.example.btuapp.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.btuapp.R

class loadingfragment :DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =LayoutInflater.from(context).inflate(R.layout.loading_fragment,null)



        return  view
    }
}