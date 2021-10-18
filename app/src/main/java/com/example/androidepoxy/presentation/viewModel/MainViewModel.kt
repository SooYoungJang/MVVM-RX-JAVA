package com.example.androidepoxy.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.model.NaverShopVo
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
import com.example.androidepoxy.domain.usecase.GetShopListUseCase
import com.example.androidepoxy.presentation.model.ProductParams
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val getShopListUseCase: GetShopListUseCase
) : ViewModel() {

    private val tag = MainViewModel::class.java.simpleName
    private val _movieList = MutableLiveData<NaverMovieVo>()
    val movieList: LiveData<NaverMovieVo>
        get() = _movieList

    private val _shopList = MutableLiveData<NaverShopVo>()
    val shopList: LiveData<NaverShopVo>
        get() = _shopList

    init {

    }


    /**
     * 영화 리스트에서 영화 배우이름을 가져오며, 그 배우에 맞는 상품리스트를 호출합니다.
     * @param query : 영화제목
     */
    fun getMovielist(query: String,country: String) {

        getMovieListUseCase.invoke(
            GetMovieListUseCase.Params(query,country))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .flatMap {it -> it.items.toObservable()}
            .flatMap {movieListItems ->
                getShopListUseCase.invoke(GetShopListUseCase.Params(query))
                    .map { it ->
                        ProductParams(actor = movieListItems.iterator() })
                    }
            }
            .subscribe({
  
            }, {
                Log.d(tag, " get API MovieList Error" )
            })
    }
}