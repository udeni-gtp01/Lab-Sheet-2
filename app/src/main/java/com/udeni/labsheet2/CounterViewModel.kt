package com.udeni.labsheet2

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _likeCount = MutableLiveData<Int>(0)
    private val _dislikeCount = MutableLiveData<Int>(0)
    val likeCount: LiveData<Int> get() = _likeCount
    val dislikeCount: LiveData<Int> get() = _dislikeCount

    fun init(sharedPreferences: SharedPreferences) {
        _likeCount.value = sharedPreferences.getString("likecount", "0")?.toInt()
        _dislikeCount.value = sharedPreferences.getString("dislikecount", "0")?.toInt()
    }

    fun performLike() {
        _likeCount.value = _likeCount.value?.plus(1)
    }

    fun performDislike() {
        _dislikeCount.value = _dislikeCount.value?.plus(1)
    }

    fun startFromSavedCount(likecount: Int, dislikecount: Int) {
        _likeCount.value = likecount
        _dislikeCount.value = dislikecount
    }
}