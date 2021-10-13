package com.example.androidepoxy.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.R
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Carousel.setDefaultGlobalSnapHelperFactory(null)
        viewModel.movieList.observe(this, Observer {
            Log.d("test", it)
        })

    }

}