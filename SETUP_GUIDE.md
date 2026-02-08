# AI News App - Complete Setup Guide

## 📋 Table of Contents
1. [Quick Start](#quick-start)
2. [API Keys Setup](#api-keys-setup)
3. [Project Configuration](#project-configuration)
4. [Build and Run](#build-and-run)
5. [Features Overview](#features-overview)
6. [Code Architecture](#code-architecture)

---

## 🚀 Quick Start

### What You'll Need:
1. **Android Studio** (Hedgehog or newer)
2. **Gemini API Key** (Required) - Get from: https://makersuite.google.com/app/apikey
3. **News API Key** (Optional) - Get from: https://newsapi.org/register

---

## 🔑 API Keys Setup

### Step 1: Get Gemini API Key (REQUIRED)

1. **Visit Google AI Studio:**
    - Go to: https://makersuite.google.com/app/apikey

2. **Sign in:**
    - Use your Google account to sign in

3. **Create API Key:**
    - Click "Create API Key" button
    - Select "Create API key in new project" or use existing project

4. **Copy the Key:**
    - Copy the generated API key (starts with "AI...")
    - Keep it safe - you'll need it in Step 2

5. **Add to MainActivity.kt:**
   ```kotlin
   // In MainActivity.kt, line ~24
   val GEMINI_API_KEY = "AIza..."  // Replace with your actual key
   ```

### Step 2: Get News API Key (OPTIONAL)

The app includes mock news data, so this is optional. If you want real news:

1. **Visit NewsAPI.org:**
    - Go to: https://newsapi.org/register

2. **Sign up:**
    - Enter your email and password
    - Verify your email

3. **Get API Key:**
    - Login to your account
    - Copy your API key from the dashboard

4. **Add to NewsApiService.kt:**
   ```kotlin
   // In NewsApiService.kt, line ~13
   private val API_KEY = "your_news_api_key_here"
   ```

---

## 🛠 Project Configuration

### File Structure Overview:
```
AINewsApp/
├── app/
│   ├── build.gradle.kts          ← Dependencies
│   ├── src/main/
│   │   ├── AndroidManifest.xml   ← Permissions
│   │   ├── java/com/example/ainewsapp/
│   │   │   ├── MainActivity.kt   ← ADD GEMINI KEY HERE
│   │   │   ├── model/
│   │   │   ├── network/
│   │   │   │   └── NewsApiService.kt  ← ADD NEWS API KEY HERE (optional)
│   │   │   ├── service/
│   │   │   ├── viewmodel/
│   │   │   └── ui/
│   │   └── res/
└── README.md
```

### Critical Files to Configure:

#### 1. MainActivity.kt
**Location:** `app/src/main/java/com/example/ainewsapp/MainActivity.kt`

**What to change:**
```kotlin
// Line ~24 - MUST UPDATE THIS
val GEMINI_API_KEY = "YOUR_GEMINI_API_KEY"  // ← Replace this
```

**Change to:**
```kotlin
val GEMINI_API_KEY = "AIzaSyD..."  // Your actual Gemini key
```

#### 2. NewsApiService.kt (Optional)
**Location:** `app/src/main/java/com/example/ainewsapp/network/NewsApiService.kt`

**What to change:**
```kotlin
// Line ~13 - Optional (mock data works without this)
private val API_KEY = "YOUR_API_KEY"  // ← Replace this
```

**Change to:**
```kotlin
private val API_KEY = "abc123..."  // Your actual News API key
```

---

## 🏗 Build and Run

### Option 1: Using Android Studio

1. **Open Project:**
    - Launch Android Studio
    - File → Open → Select `AINewsApp` folder
    - Wait for Gradle sync to complete

2. **Configure API Keys:**
    - Follow the steps in "Project Configuration" above

3. **Select Device:**
    - Click the device dropdown in toolbar
    - Choose an emulator or connected device
    - Recommended: API 24 or higher

4. **Run:**
    - Click green "Run" button (▶)
    - Wait for build to complete
    - App will launch automatically

### Option 2: Using Gradle Command Line

```bash
# Navigate to project directory
cd AINewsApp

# Build the app
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug
```

---

## ✨ Features Overview

### 1. News List Display
- Shows 5 news articles in cards
- Each card has:
    - Rectangle image (full width, 250dp height)
    - Title (bold, max 2 lines)
    - Description (max 2 lines when collapsed)

### 2. Expand/Collapse Functionality
- **Tap card** → Expands to show full content
- **Tap again** → Collapses back to 2 lines
- **Only one card** can be expanded at a time

### 3. Gemini AI Summarization
- **Gemini FAB** appears when card is expanded
- **Tap FAB** → AI summarizes the article
- **Summary is read aloud** using Text-to-Speech
- **Tap FAB again** → Stops reading

### 4. UI Features
- Material Design 3
- Dynamic color scheme
- Smooth animations
- Loading indicators
- Error handling

---

## 🏛 Code Architecture

### MVVM Pattern

```
View (Compose UI)
    ↓
ViewModel (NewsViewModel)
    ↓
Services (GeminiService, TextToSpeechService, NewsApiService)
    ↓
Network (Ktor Client)
```

### Key Components:

#### 1. **NewsViewModel**
- Manages app state
- Handles business logic
- Coordinates services

#### 2. **NewsApiService**
- Fetches news from API
- Provides mock data fallback
- Uses Ktor client

#### 3. **GeminiService**
- Integrates with Gemini AI
- Generates summaries
- Handles API errors

#### 4. **TextToSpeechService**
- Android TTS integration
- Manages speech state
- Handles start/stop

#### 5. **HomeScreen**
- Main UI screen
- Displays news list
- Handles user interactions

#### 6. **NewsCard**
- Reusable card component
- Expand/collapse animation
- Image and text layout

---

## 🔧 Customization Options

### Change Number of Articles:
In `NewsApiService.kt`:
```kotlin
// Change pageSize parameter
client.get("...&pageSize=5&...")  // Change 5 to desired number
```

### Change Image Height:
In `NewsCard.kt`:
```kotlin.height(250.dp)  // Change to desired height
```

### Change Description Lines:
In `NewsCard.kt`:
```kotlin
maxLines = if (isExpanded) Int.MAX_VALUE else 2  // Change 2 to desired lines
```

### Change TTS Speed:
In `TextToSpeechService.kt`:
```kotlin
tts?.setSpeechRate(1.0f)  // 0.5 = slower, 2.0 = faster
```

---

## 🐛 Common Issues & Solutions

### Issue 1: "API Key not valid"
**Solution:**
- Double-check your Gemini API key
- Make sure there are no extra spaces
- Verify key is active at https://makersuite.google.com

### Issue 2: "No internet connection"
**Solution:**
- Check AndroidManifest.xml has internet permission
- Verify device has internet access
- Try using mock data (no News API key needed)

### Issue 3: Images not loading
**Solution:**
- Mock data uses Picsum photos
- Ensure internet connectivity
- Check if Coil dependency is properly installed

### Issue 4: TTS not working
**Solution:**
- Go to device Settings → Language & Input → Text-to-Speech
- Install/update TTS engine
- Test TTS in device settings

### Issue 5: Gradle sync failed
**Solution:**
- Check internet connection
- File → Invalidate Caches / Restart
- Verify JDK version (need JDK 8+)

---

## 📱 Testing the App

### Manual Testing Checklist:

- [ ] App launches successfully
- [ ] News articles load (5 articles visible)
- [ ] Images load correctly
- [ ] Can expand card by tapping
- [ ] Only one card expands at a time
- [ ] Gemini FAB appears when card expanded
- [ ] Gemini FAB disappears when card collapsed
- [ ] Tapping Gemini FAB triggers summarization
- [ ] TTS reads summary aloud
- [ ] Can stop TTS by tapping FAB
- [ ] Smooth animations
- [ ] No crashes

---

## 🎨 UI Screenshots Description

### Home Screen:
- Top bar: "AI News" title with blue background
- Content: Scrollable list of 5 news cards
- Each card: Image + Title + Description (2 lines)
- Clean, modern Material Design 3

### Expanded Card:
- Same layout but description shows full content
- "Tap to collapse" hint at bottom
- Gemini FAB visible in bottom-right corner

### While Speaking:
- Gemini FAB changes to Stop icon
- Red color indicates active state
- Loading spinner during summarization

---

## 📞 Support & Resources

### Official Documentation:
- **Jetpack Compose:** https://developer.android.com/jetpack/compose
- **Ktor:** https://ktor.io/docs/client.html
- **Gemini API:** https://ai.google.dev/docs
- **NewsAPI:** https://newsapi.org/docs

### Video Tutorials:
- Search YouTube for "Jetpack Compose tutorial"
- Search "Gemini AI Android integration"

---

## 🎓 Learning Points

This project demonstrates:
- ✅ Jetpack Compose UI development
- ✅ MVVM architecture pattern
- ✅ Ktor HTTP client usage
- ✅ REST API integration
- ✅ AI/ML integration (Gemini)
- ✅ Text-to-Speech implementation
- ✅ State management with Flow
- ✅ Coroutines and async operations
- ✅ Material Design 3
- ✅ Image loading with Coil

---

## 📄 License

Educational project for learning Android development.

---

## ✅ Next Steps After Setup

1. Run the app and verify it works
2. Try expanding different news cards
3. Test the Gemini AI summarization
4. Customize the UI to your preferences
5. Experiment with different news sources
6. Add more features (share, save, etc.)

---

**Need Help?**
- Check the troubleshooting section
- Review the code comments
- Search for specific errors online
- Test with mock data first before using real APIs

Good luck building your AI News App! 🚀