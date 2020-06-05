package com.zicen.jetpackdemo.ui.publish

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val mText: MutableLiveData<String> = MutableLiveData()

    val text: LiveData<String>
        get() = mText

    init {
        mText.value = "This is my fragment"
    }
}