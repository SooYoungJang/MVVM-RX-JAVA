package com.example.androidepoxy.data.mapper

import com.example.androidepoxy.data.model.Item
import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.domain.model.MovieItemVo
import com.example.androidepoxy.domain.model.NaverMovieVo

internal fun NaverMovieResponse.toDomain(): NaverMovieVo {
    return NaverMovieVo(
        this.display,
        this.items.map { it.toDomain() },
        this.lastBuildDate,
        this.start,
        this.total
    )
}
  
internal fun Item.toDomain(): MovieItemVo {
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
