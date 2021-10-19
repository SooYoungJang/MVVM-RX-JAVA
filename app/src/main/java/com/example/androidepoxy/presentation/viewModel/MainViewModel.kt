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
import com.example.androidepoxy.presentation.model.SearchParams
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

    private val _productList = MutableLiveData<ProductParams>()
    val productList: LiveData<ProductParams>
        get() = _productList

    /**
     * 영화 리스트에서 영화 배우이름을 가져오며, 그 배우에 맞는 상품리스트를 호출합니다.
     * @param query : 영화제목
     */
    fun getMovielist(searchParams : SearchParams) {

        getMovieListUseCase.invoke(
            GetMovieListUseCase.Params(searchParams.searchName,searchParams.searchCountry))
            .flatMap {movieItems ->
                getShopListUseCase.invoke(GetShopListUseCase.Params(searchParams.searchName))
                    .map { shopItem ->
                        ProductParams(
                            movieItem = movieItems.items,
                            shopItem = shopItem.items
                        )
                    }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _productList.postValue(it)
            }, {
                Log.d(tag, " get API MovieList Error" )
            })
    }

}