package com.example.androidepoxy.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidepoxy.R
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.widget.Toast




@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}