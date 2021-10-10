package com.example.androidepoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.api.StarBucksApiService
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.di.RetroFitModule
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    var fds : RetroFitModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Carousel.setDefaultGlobalSnapHelperFactory(null)


    }
}