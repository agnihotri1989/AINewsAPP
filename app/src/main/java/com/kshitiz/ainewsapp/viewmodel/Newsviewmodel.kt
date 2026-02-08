package com.kshitiz.ainewsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kshitiz.ainewsapp.model.Article
import com.kshitiz.ainewsapp.network.NewsApiService
import com.kshitiz.ainewsapp.service.GeminiService
import com.kshitiz.ainewsapp.service.TextToSpeechService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val newsApiService = NewsApiService()
    private lateinit var geminiService: GeminiService
    private val ttsService = TextToSpeechService(application)

    private val _newsArticles = MutableStateFlow<List<Article>>(emptyList())
    val newsArticles: StateFlow<List<Article>> = _newsArticles

    private val _expandedCardIndex = MutableStateFlow<Int?>(null)
    val expandedCardIndex: StateFlow<Int?> = _expandedCardIndex

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isSummarizing = MutableStateFlow(false)
    val isSummarizing: StateFlow<Boolean> = _isSummarizing

    val isSpeaking: StateFlow<Boolean> = ttsService.isSpeaking

    fun initializeGemini(apiKey: String) {
        geminiService = GeminiService(apiKey)
    }

    fun fetchNews() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = newsApiService.getTopHeadlines()
                _newsArticles.value = response.articles
            } catch (e: Exception) {
                // Handle error - articles will remain empty or show error state
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun toggleCardExpansion(index: Int) {
        _expandedCardIndex.value = if (_expandedCardIndex.value == index) {
            null
        } else {
            index
        }
    }

    fun summarizeAndSpeak() {
        val expandedIndex = _expandedCardIndex.value
        if (expandedIndex != null && expandedIndex < _newsArticles.value.size) {
            val article = _newsArticles.value[expandedIndex]
            val contentToSummarize = article.content ?: article.description

            viewModelScope.launch {
                try {
                    _isSummarizing.value = true
                    val summary = geminiService.summarizeNews(contentToSummarize)
                    ttsService.speak(summary)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    _isSummarizing.value = false
                }
            }
        }
    }

    fun stopSpeaking() {
        ttsService.stop()
    }

    override fun onCleared() {
        super.onCleared()
        ttsService.shutdown()
    }
}