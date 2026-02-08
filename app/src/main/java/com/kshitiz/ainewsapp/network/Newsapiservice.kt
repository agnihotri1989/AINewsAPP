package com.kshitiz.ainewsapp.network

import com.kshitiz.ainewsapp.model.Article
import com.kshitiz.ainewsapp.model.NewsResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

class NewsApiService {
    private val client = KtorClient.client

    // Using NewsAPI.org - FREE API
    // You need to get an API key from: https://newsapi.org/register
    // Replace YOUR_API_KEY with your actual API key
    private val API_KEY = "YOUR_API_KEY"

    suspend fun getTopHeadlines(): NewsResponse {
        return try {
            client.get("https://newsapi.org/v2/top-headlines?country=us&pageSize=5&apiKey=$API_KEY")
                .body()
        } catch (e: Exception) {
            // Fallback to mock data if API fails
            getMockNews()
        }
    }

    // Mock data for testing without API key
    private fun getMockNews(): NewsResponse {
        return NewsResponse(
            articles = listOf(
                Article(
                    title = "AI Revolution: New Breakthrough in Machine Learning",
                    description = "Scientists announce major advancement in artificial intelligence technology",
                    urlToImage = "https://picsum.photos/seed/ai1/800/450",
                    content = "In a groundbreaking development, researchers at leading tech companies have announced a significant breakthrough in machine learning algorithms. This new advancement promises to revolutionize how AI systems process and understand complex data patterns. The technology could have far-reaching implications for various industries including healthcare, finance, and autonomous systems. Experts believe this could be the most significant AI development in the past decade, potentially transforming how we interact with technology on a daily basis."
                ),
                Article(
                    title = "Global Climate Summit Reaches Historic Agreement",
                    description = "World leaders commit to ambitious carbon reduction targets",
                    urlToImage = "https://picsum.photos/seed/climate2/800/450",
                    content = "In an unprecedented move, world leaders from over 190 countries have reached a historic agreement on climate action at the Global Climate Summit. The agreement includes binding commitments to reduce carbon emissions by 50% over the next decade. Environmental experts are calling this a watershed moment in the fight against climate change. The accord also includes provisions for financial support to developing nations and investment in renewable energy infrastructure. This represents the most comprehensive climate action plan ever agreed upon at the international level."
                ),
                Article(
                    title = "Space Exploration: First Crewed Mission to Mars Approved",
                    description = "International space agency announces plans for historic Mars mission",
                    urlToImage = "https://picsum.photos/seed/space3/800/450",
                    content = "The international space community has officially approved the first crewed mission to Mars, scheduled to launch in 2028. This historic mission will carry a crew of six astronauts on a journey that will take approximately seven months. The mission represents humanity's most ambitious space exploration endeavor to date. Engineers and scientists have been working for years to develop the necessary technology and life support systems for this groundbreaking journey. The mission aims to establish the first human presence on Mars and conduct extensive scientific research on the Red Planet."
                ),
                Article(
                    title = "Medical Breakthrough: New Treatment Shows Promise for Cancer",
                    description = "Clinical trials reveal revolutionary cancer treatment with high success rates",
                    urlToImage = "https://picsum.photos/seed/medical4/800/450",
                    content = "A revolutionary new cancer treatment has shown remarkable success in clinical trials, offering hope to millions of patients worldwide. The treatment, which uses advanced immunotherapy techniques, has demonstrated an 85% success rate in early trials. Medical researchers describe this as a potential game-changer in oncology. The therapy works by training the patient's own immune system to recognize and attack cancer cells more effectively. If approved, this treatment could become available to patients within the next two years, representing one of the most significant medical advances in cancer treatment."
                ),
                Article(
                    title = "Tech Giant Unveils Next-Generation Quantum Computer",
                    description = "New quantum computing system achieves unprecedented processing power",
                    urlToImage = "https://picsum.photos/seed/quantum5/800/450",
                    content = "A major technology company has unveiled its latest quantum computer, which achieves processing capabilities far beyond anything previously developed. The new system can perform calculations in seconds that would take traditional supercomputers thousands of years to complete. This advancement brings us closer to practical applications of quantum computing in fields such as drug discovery, cryptography, and complex scientific simulations. Industry experts believe this marks a turning point in the quantum computing race and could accelerate innovation across multiple sectors of technology and science."
                )
            )
        )
    }
}