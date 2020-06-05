package com.zicen.jetpackdemo.ui.publish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zicen.jetpackdemo.R
import com.zicen.libnavannotation.ActivityDestination

@ActivityDestination(pageUrl = "main/tabs/publish")
class PublishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)
    }
}
