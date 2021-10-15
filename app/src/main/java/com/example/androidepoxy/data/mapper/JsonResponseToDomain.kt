package com.example.androidepoxy.data.mapper

import com.example.androidepoxy.data.model.MovieItem
import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.data.model.NaverShopResponse
import com.example.androidepoxy.data.model.ShopItem
import com.example.androidepoxy.domain.model.MovieItemVo
import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.model.NaverShopVo
import com.example.androidepoxy.domain.model.ShopItemVo

internal fun NaverMovieResponse.toDomain(): NaverMovieVo {
    return NaverMovieVo(
        this.display,
        this.items.map { it.toDomain() },
        this.lastBuildDate,
        this.start,
        this.total
    )
}

internal fun MovieItem.toDomain(): MovieItemVo {
    return MovieItemVo(
        this.actor,
        this.director,
        this.image,
        this.link,
        this.pubDate,
        this.subtitle,
        this.title,
        this.userRating
    )
}


internal fun NaverShopResponse.toDomain(): NaverShopVo {
    return NaverShopVo(
        this.display,
        this.items.map { it.toDoamin() },
        this.lastBuildDate,
        this.start,
        this.total
    )
}

internal fun ShopItem.toDoamin(): ShopItemVo {
    return ShopItemVo(
        this.brand,
        this.category1,
        this.category2,
        this.category3,
        this.category4,
        this.hprice,
        this.image,
        this.link,
        this.lprice,
        this.maker,
        this.mallName,
        this.productId,
        this.productType,
        this.title
    )
}