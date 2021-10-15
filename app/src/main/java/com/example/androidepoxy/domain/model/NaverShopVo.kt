package com.example.androidepoxy.domain.model

import com.example.androidepoxy.data.model.MovieItem

data class NaverShopVo(
    val display: Int,
    val items: List<ShopItemVo>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)


data class ShopItemVo(
    val brand: String,
    val category1: String,
    val category2: String,
    val category3: String,
    val category4: String,
    val hprice: String,
    val image: String,
    val link: String,
    val lprice: String,
    val maker: String,
    val mallName: String,
    val productId: String,
    val productType: String,
    val title: String
)
