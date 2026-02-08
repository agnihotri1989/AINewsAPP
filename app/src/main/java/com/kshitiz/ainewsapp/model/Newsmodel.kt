package com.kshitiz.ainewsapp.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val articles: List<Article>
)

@Serializable
data class Article(
    val title: String,
    val description: String,
    val urlToImage: String?,
    val content: String?
)
