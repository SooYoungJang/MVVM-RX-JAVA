package com.example.androidepoxy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Carousel.setDefaultGlobalSnapHelperFactory(null)
        testa()

        viewModel.ProductAllLiveData.observe(this, Observer {
            var count = 1
            it.menus?.forEach {
                Log.d("sdfsdf" , "ssss $count  ${it.name}")
                count++
            }

        })
    }
    private fun testa() {
        viewModel.getMenu()
    }

}