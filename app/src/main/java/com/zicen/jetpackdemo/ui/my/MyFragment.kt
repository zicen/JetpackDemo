package com.zicen.jetpackdemo.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.zicen.jetpackdemo.R
import com.zicen.jetpackdemo.ui.publish.MyViewModel
import com.zicen.libnavannotation.FragmentDestination

@FragmentDestination(pageUrl = "main/tabs/my")
class MyFragment : Fragment() {

    private var notificationsViewModel: MyViewModel? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        notificationsViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView = root.findViewById<TextView>(R.id.text_notifications)
        notificationsViewModel?.text?.observe(this, Observer { s -> textView.text = s })
        return root
    }
}