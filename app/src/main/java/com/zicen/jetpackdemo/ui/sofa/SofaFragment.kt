package com.zicen.jetpackdemo.ui.sofa

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

@FragmentDestination(pageUrl = "main/tabs/sofa")
class SofaFragment : Fragment() {

    private var dashboardViewModel: SofaViewModel? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(SofaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView = root.findViewById<TextView>(R.id.text_dashboard)
        dashboardViewModel?.text?.observe(this, Observer { s -> textView.text = s })
        return root
    }
}