# AI News App - Android Application

A modern Android news application built with Jetpack Compose that fetches news articles and uses Google's Gemini AI to summarize and read them aloud.
## Screenshots
<p align="center">
  <img src="screenshots/1.png" width="220" />
  <img src="screenshots/2.png" width="220" />
</p>
## Features

✨ **Core Features:**
- Clean, modern UI built with Jetpack Compose
- Card-based news list with expand/collapse functionality
- Image loading with Coil
- Maximum 5 news articles displayed
- Rectangular images (full width, 250dp height)
- Short descriptions (2 lines) that expand to full content on tap

🤖 **AI Features:**
- Gemini AI integration for news summarization
- Text-to-Speech for reading summaries aloud
- Floating Action Button (Gemini icon) appears when a card is expanded
- AI summarizes the expanded news article and reads it in voice mode

## Tech Stack

- **UI Framework:** Jetpack Compose
- **Networking:** Ktor Client
- **Image Loading:** Coil
- **AI:** Google Generative AI (Gemini)
- **Text-to-Speech:** Android TTS
- **Architecture:** MVVM with ViewModel
- **Language:** Kotlin

## Setup Instructions

### Prerequisites
1. Android Studio (latest version)
2. JDK 8 or higher
3. Android SDK API 24+

### API Keys Required

#### 1. News API (Optional - Mock data included)
If you want to use real news data:
- Visit: https://newsapi.org/register
- Sign up for a FREE API key
- Open `NewsApiService.kt` and replace `YOUR_API_KEY` with your actual API key

**Note:** The app includes mock news data, so it will work without a News API key.

#### 2. Google Gemini API (Required for AI features)
To get your Gemini API key:
- Visit: https://makersuite.google.com/app/apikey
- Sign in with your Google account
- Click "Create API Key"
- Copy the API key
- Open `MainActivity.kt` and replace `YOUR_GEMINI_API_KEY` with your actual API key

### Installation Steps

1. **Clone or Download the project:**
   ```bash
   cd AINewsApp
   ```

2. **Open in Android Studio:**
    - Open Android Studio
    - Select "Open an Existing Project"
    - Navigate to the AINewsApp folder
    - Click "OK"

3. **Configure API Keys:**
    - Open `app/src/main/java/com/example/ainewsapp/MainActivity.kt`
    - Replace `YOUR_GEMINI_API_KEY` with your Gemini API key
    - (Optional) Open `app/src/main/java/com/example/ainewsapp/network/NewsApiService.kt`
    - Replace `YOUR_API_KEY` with your News API key

4. **Sync Gradle:**
    - Click "Sync Project with Gradle Files" in Android Studio
    - Wait for dependencies to download

5. **Run the App:**
    - Connect an Android device or start an emulator (API 24+)
    - Click the "Run" button (green play icon)
    - Select your device
    - Wait for the app to install and launch

## How to Use

1. **View News:**
    - The app displays 5 news articles in a scrollable list
    - Each card shows an image and a short description (2 lines)

2. **Expand Article:**
    - Tap on any card to expand it and see the full description
    - Only one card can be expanded at a time
    - The Gemini FAB appears in the bottom-right corner when a card is expanded

3. **AI Summarization:**
    - With a card expanded, tap the Gemini icon (sparkle icon)
    - The AI will generate a summary of the article
    - The summary will be read aloud using Text-to-Speech

4. **Stop Speaking:**
    - While speaking, the FAB changes to a Stop icon
    - Tap it to stop the speech

5. **Collapse Article:**
    - Tap the expanded card again to collapse it back to 2 lines
    - The Gemini FAB will disappear

## Project Structure

```
AINewsApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/ainewsapp/
│   │   │   ├── model/
│   │   │   │   └── NewsModel.kt          # Data models
│   │   │   ├── network/
│   │   │   │   ├── KtorClient.kt         # HTTP client setup
│   │   │   │   └── NewsApiService.kt     # API service
│   │   │   ├── service/
│   │   │   │   ├── GeminiService.kt      # Gemini AI integration
│   │   │   │   └── TextToSpeechService.kt # TTS service
│   │   │   ├── viewmodel/
│   │   │   │   └── NewsViewModel.kt      # ViewModel
│   │   │   ├── ui/
│   │   │   │   ├── components/
│   │   │   │   │   └── NewsCard.kt       # News card component
│   │   │   │   ├── screens/
│   │   │   │   │   └── HomeScreen.kt     # Home screen
│   │   │   │   └── theme/
│   │   │   │       ├── Theme.kt          # App theme
│   │   │   │       └── Type.kt           # Typography
│   │   │   └── MainActivity.kt           # Main activity
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
```

## Dependencies

- **Jetpack Compose:** Modern UI toolkit
- **Ktor Client:** HTTP client for API calls
- **Coil:** Image loading library
- **Kotlinx Serialization:** JSON parsing
- **Google Generative AI:** Gemini API integration
- **Material3:** Material Design components

## Troubleshooting

### App crashes on startup:
- Make sure you've added your Gemini API key in `MainActivity.kt`
- Check that you have internet permission in AndroidManifest.xml

### Images not loading:
- Ensure you have internet connectivity
- Check the mock data URLs are accessible

### TTS not working:
- Make sure your device has TTS data installed
- Go to Settings > Language & Input > Text-to-Speech output

### Gemini API errors:
- Verify your API key is correct
- Ensure you have internet connectivity
- Check your API quota at https://makersuite.google.com

## License

This project is for educational purposes.

## Credits

- News data: NewsAPI.org (or mock data)
- AI: Google Gemini
- Images: Picsum Photos (for mock data)
