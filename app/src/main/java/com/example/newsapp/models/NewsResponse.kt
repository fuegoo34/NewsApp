package com.example.newsapp.models

data class NewsResponse(
    val articles: MutableList<Articles>,
    val status: String,
    val totalResults: Int
) {
}