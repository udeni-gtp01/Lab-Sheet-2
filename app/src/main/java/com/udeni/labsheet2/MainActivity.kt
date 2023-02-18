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

        viewModel.init(getAppSharedPreferences())

        binding.btnLike.setOnClickListener {
            viewModel.performLike()
        }
        binding.btnDislike.setOnClickListener {
            viewModel.performDislike()
        }
    }

    override fun onStop() {
        super.onStop()
        var editor = getAppSharedPreferences().edit()
        editor.putString("likecount", binding.lblCountLike.text.toString())
        editor.putString("dislikecount", binding.lblCountDislike.text.toString())
        editor.commit()
    }

    fun getAppSharedPreferences(): SharedPreferences {
        return getSharedPreferences("LABSHEET2", Context.MODE_PRIVATE)
    }
}