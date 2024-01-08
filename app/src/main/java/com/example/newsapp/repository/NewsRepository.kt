package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Articles

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun  getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(articles: Articles) = db.getArticleDao().upsert(articles)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(articles: Articles) = db.getArticleDao().deleteArticle(articles)

}