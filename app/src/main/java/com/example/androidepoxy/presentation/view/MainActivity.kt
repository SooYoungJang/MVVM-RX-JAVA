package com.example.androidepoxy.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.R
import com.example.androidepoxy.databinding.ActivityMainBinding
import com.example.androidepoxy.presentation.model.SearchParams
import com.example.androidepoxy.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Carousel.setDefaultGlobalSnapHelperFactory(null)


        viewModel.getMovielist(SearchParams("아이언맨","US")) //뷰단을 만들기 전에 임시로 테스트용. 하드코딩.

        viewModel.productList.observe(this, Observer {
            Log.d(tag," testes == ${it.movieItem.size}")
            Log.d(tag," testes == ${it.shopItem.size}")
        })
    }
}