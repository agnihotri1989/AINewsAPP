package com.kshitiz.ainewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kshitiz.ainewsapp.ui.screens.HomeScreen
import com.kshitiz.ainewsapp.ui.theme.AINewsAppTheme
import com.kshitiz.ainewsapp.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AINewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AINewsAppTheme {
        Greeting("Android")
    }
}

@Composable
fun NewsApp() {
    val viewModel: NewsViewModel = viewModel()

    // Initialize Gemini API


    LaunchedEffect(Unit) {
        viewModel.initializeGemini()
        viewModel.fetchNews()
    }

    val newsArticles by viewModel.newsArticles.collectAsState()
    val expandedCardIndex by viewModel.expandedCardIndex.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isSummarizing by viewModel.isSummarizing.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()

    HomeScreen(
        newsArticles = newsArticles,
        expandedCardIndex = expandedCardIndex,
        isLoading = isLoading,
        isSummarizing = isSummarizing,
        isSpeaking = isSpeaking,
        onCardClick = { index ->
            viewModel.toggleCardExpansion(index)
        },
        onGeminiClick = {
            viewModel.summarizeAndSpeak()
        },
        onStopSpeaking = {
            viewModel.stopSpeaking()
        }
    )
}
