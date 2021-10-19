package com.example.androidepoxy.presentation.model

import com.example.androidepoxy.domain.model.MovieItemVo
import com.example.androidepoxy.domain.model.ShopItemVo

data class ProductParams(
    val movieItem:  List<MovieItemVo>,
    val shopItem: List<ShopItemVo>
)

data class SearchParams(
    val searchName: String,
    val searchCountry: String
)