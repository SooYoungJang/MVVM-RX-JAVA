package com.example.androidepoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.api.StarBucksApiService
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.di.RetroFitModule
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity@Inject constructor(
    private val starBucksApiService: StarBucksApiService
): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Carousel.setDefaultGlobalSnapHelperFactory(null)


    }
    suspend fun test() {
        starBucksApiService.getMenu().let {
            it.menus?.forEach {
                Log.d("sdfsf", "ddd ${it.name}")
            }
        }
    }
}