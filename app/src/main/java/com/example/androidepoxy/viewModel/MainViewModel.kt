package com.example.androidepoxy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidepoxy.api.StarBucksApiService
import com.example.androidepoxy.model.MenuResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val starBucksApiService: StarBucksApiService): ViewModel(){

    private val _ProductAllLiveData = MutableLiveData<MenuResponse>()
    val ProductAllLiveData: LiveData<MenuResponse>
        get() = _ProductAllLiveData


    fun getMenu() {
        viewModelScope.launch {
            testtest()
        }
    }

    suspend fun testtest() {
        starBucksApiService.getMenu().body().let {
            _ProductAllLiveData.value = it
        }
    }

}