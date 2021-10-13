package com.example.androidepoxy.domain.model

data class NaverMovieVo(
    val display: Int,
    val items: List<MovieItemVo>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)

data class MovieItemVo(
    val actor: String,
    val director: String,
    val image: String,
    val link: String,
    val pubDate: String,
    val subtitle: String,
    val title: String,
    val userRating: String
)