package com.example.androidepoxy.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val tag = MainViewModel::class.java.simpleName
    private val _movieList = MutableLiveData<NaverMovieVo>()
    val movieList: LiveData<NaverMovieVo>
        get() = _movieList

    init {
        getMovielist()
    }


    private fun getMovielist() {
        getMovieListUseCase.invoke(
            GetMovieListUseCase.Params("아이언맨", "US"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _movieList.postValue(it)
            }, {
                Log.d(tag, " get API MovieList Error" )
            })
    }
}