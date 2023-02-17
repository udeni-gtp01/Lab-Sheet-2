package com.udeni.labsheet2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.udeni.labsheet2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.counterVM = viewModel
        binding.lifecycleOwner=this
        val lblLikeCount: TextView = binding.lblCountLike
        val btnLike: Button = binding.btnLike

        btnLike.setOnClickListener {
            viewModel.performLike()
            lblLikeCount.text = viewModel.likeCount.toString()
        }
    }
}