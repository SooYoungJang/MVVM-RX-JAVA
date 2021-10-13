package com.example.androidepoxy.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = MutableLiveData<String>()
    val movieList: LiveData<String>
        get() = _movieList

    init {
        getMovielist()
    }


    private fun getMovielist() {
        _movieList.postValue("testesttestestst")
    }
}