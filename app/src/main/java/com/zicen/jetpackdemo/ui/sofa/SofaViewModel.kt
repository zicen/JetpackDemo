package com.zicen.jetpackdemo.ui.sofa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SofaViewModel : ViewModel() {

    private val mText: MutableLiveData<String> = MutableLiveData()

    val text: LiveData<String>
        get() = mText

    init {
        mText.value = "This is sofa fragment"
    }
}