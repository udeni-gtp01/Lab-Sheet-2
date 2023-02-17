package com.udeni.labsheet2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _likeCount=MutableLiveData<Int>(0)
    val likeCount:LiveData<Int>get() = _likeCount
    fun performLike(){
        _likeCount.value= _likeCount.value?.plus(1)
    }
}