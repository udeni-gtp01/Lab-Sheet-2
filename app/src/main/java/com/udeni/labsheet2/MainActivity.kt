package com.udeni.labsheet2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.udeni.labsheet2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: CounterViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.counterVM = viewModel
        binding.lifecycleOwner = this

        binding.btnLike.setOnClickListener {
            viewModel.performLike()
            AppSharedPreference(this).saveLikes(viewModel.likeCount.value ?: 0)
        }
        binding.btnDislike.setOnClickListener {
            viewModel.performDislike()
            AppSharedPreference(this).saveDislikes(viewModel.dislikeCount.value ?: 0)
        }
    }

    override fun onResume() {
        super.onResume()
        val savedLikeCount = AppSharedPreference(this).getLikes()
        val savedDislikeCount = AppSharedPreference(this).getDislikes()
        viewModel.startFromSavedCount(savedLikeCount, savedDislikeCount)
    }
}