package com.kshitiz.ainewsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kshitiz.ainewsapp.model.Article
import com.kshitiz.ainewsapp.ui.components.NewsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    newsArticles: List<Article>,
    expandedCardIndex: Int?,
    isLoading: Boolean,
    isSummarizing: Boolean,
    isSpeaking: Boolean,
    onCardClick: (Int) -> Unit,
    onGeminiClick: () -> Unit,
    onStopSpeaking: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "AI News",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            // Only show FAB if a card is expanded
            if (expandedCardIndex != null) {
                FloatingActionButton(
                    onClick = {
                        if (isSpeaking) {
                            onStopSpeaking()
                        } else {
                            onGeminiClick()
                        }
                    },
                    containerColor = if (isSpeaking)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(64.dp)
                ) {
                    if (isSummarizing) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(32.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Icon(
                            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.AutoAwesome,
                            contentDescription = if (isSpeaking) "Stop Speaking" else "Summarize with Gemini",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                newsArticles.isEmpty() -> {
                    Text(
                        text = "No news available",
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        itemsIndexed(newsArticles) { index, article ->
                            NewsCard(
                                article = article,
                                isExpanded = expandedCardIndex == index,
                                onCardClick = { onCardClick(index) }
                            )
                        }

                        // Bottom spacing for FAB
                        item {
                            Spacer(modifier = Modifier.height(80.dp))
                        }
                    }
                }
            }
        }
    }
}
