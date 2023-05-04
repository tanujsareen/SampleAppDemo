package com.demo.sampleapp.ui.vm

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var position: Int = -1

    fun getImages(): List<Object> {
        return arrayListOf()//homeRepository.getImages()
    }


}