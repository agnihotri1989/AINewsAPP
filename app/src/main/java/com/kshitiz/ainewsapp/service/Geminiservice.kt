package com.kshitiz.ainewsapp.service

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.generationConfig

class GeminiService(private val apiKey: String) {

    private val model = GenerativeModel(
        modelName = "gemini-3-flash-preview",
        apiKey = apiKey,
        generationConfig = generationConfig {
            temperature = 0.7f
            topK = 40
            topP = 0.95f
            maxOutputTokens = 1024
        }
    )

    suspend fun summarizeNews(newsContent: String): String {
        return try {
            val prompt = """
                Summarize the following news article in a concise, engaging manner suitable for text-to-speech.
                Keep it under 100 words and focus on the key points.
                
                Article:
                $newsContent
                
                Summary:
            """.trimIndent()

            val response = model.generateContent(prompt)
            response.text ?: "Unable to generate summary"
        } catch (e: Exception) {
            "Error generating summary: ${e.message}"
        }
    }
}