package com.udeni.labsheet2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.udeni.labsheet2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.counterVM = viewModel
        binding.lifecycleOwner = this

        binding.btnLike.setOnClickListener {
            viewModel.performLike()
        }
        binding.btnDislike.setOnClickListener {
            viewModel.performDislike()
        }
    }
}