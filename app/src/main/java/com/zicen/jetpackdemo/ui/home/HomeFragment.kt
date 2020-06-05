package com.zicen.jetpackdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.zicen.jetpackdemo.R
import com.zicen.libnavannotation.FragmentDestination

@FragmentDestination(pageUrl = "main/tabs/home", asStarter = true)
class HomeFragment : Fragment() {

    private var homeViewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView = root.findViewById<TextView>(R.id.text_home)
        homeViewModel?.text?.observe(this, Observer { s -> textView.text = s })
        return root
    }
}