# ⚡ Quick Start Checklist

## Before You Start - Get API Keys

### 1. Gemini API Key (REQUIRED - Takes 2 minutes)
- [ ] Go to: https://makersuite.google.com/app/apikey
- [ ] Sign in with Google account
- [ ] Click "Create API Key"
- [ ] Copy the key (starts with "AIza...")

### 2. News API Key (OPTIONAL - Mock data works without this)
- [ ] Go to: https://newsapi.org/register
- [ ] Create account
- [ ] Copy API key from dashboard

---

## Setup Steps (5 minutes)

### Step 1: Open Project in Android Studio
- [ ] Launch Android Studio
- [ ] File → Open → Select `AINewsApp` folder
- [ ] Wait for Gradle sync

### Step 2: Add Gemini API Key
- [ ] Open: `app/src/main/java/com/example/ainewsapp/MainActivity.kt`
- [ ] Find line ~24: `val GEMINI_API_KEY = "YOUR_GEMINI_API_KEY"`
- [ ] Replace `YOUR_GEMINI_API_KEY` with your actual key
- [ ] Example: `val GEMINI_API_KEY = "AIzaSyDxxxxxxxxxxxxxxxxxxxxx"`

### Step 3: (Optional) Add News API Key
- [ ] Open: `app/src/main/java/com/example/ainewsapp/network/NewsApiService.kt`
- [ ] Find line ~13: `private val API_KEY = "YOUR_API_KEY"`
- [ ] Replace with your News API key
- [ ] **Skip this if you want to use mock data**

### Step 4: Run the App
- [ ] Connect Android device (API 24+) or start emulator
- [ ] Click green "Run" button (▶)
- [ ] Wait for build (~2-3 minutes first time)
- [ ] App launches!

---

## Test the App (2 minutes)

### Basic Features:
- [ ] See 5 news articles with images
- [ ] Tap a card → It expands
- [ ] See Gemini icon (sparkle) appear in bottom-right
- [ ] Tap another card → Previous collapses, new one expands

### AI Features:
- [ ] With a card expanded, tap Gemini icon
- [ ] Wait for summarization (~2-3 seconds)
- [ ] Hear the summary read aloud
- [ ] Tap Gemini icon (now shows stop icon) to stop

### Collapse:
- [ ] Tap expanded card again
- [ ] Card collapses back to 2 lines
- [ ] Gemini icon disappears

---

## ✅ You're Done!

If everything worked:
- ✨ You have a working AI News App
- 📱 It fetches and displays news
- 🤖 Gemini AI summarizes articles
- 🔊 Text-to-Speech reads summaries

---

## 🐛 Quick Troubleshooting

**App crashes immediately?**
→ Check you added Gemini API key in MainActivity.kt

**No news showing?**
→ That's okay! Mock data should work. Check internet connection.

**Gemini button does nothing?**
→ Verify Gemini API key is correct (no spaces, complete key)

**No voice/sound?**
→ Turn up device volume, check TTS in device settings

---

## 📁 Files You Modified

You should have changed these 2 files:

1. **MainActivity.kt**
    - Line ~24: Added Gemini API key

2. **NewsApiService.kt** (Optional)
    - Line ~13: Added News API key

That's it! Just 2 files to configure.

---

## 🎯 What You Built

You now have an Android app that:
- Uses **Jetpack Compose** for modern UI
- Fetches news via **Ktor HTTP client**
- Integrates **Google Gemini AI** for summarization
- Uses **Text-to-Speech** for voice reading
- Follows **MVVM architecture**
- Implements **Material Design 3**

---

## 📚 Next Steps

Want to learn more?
- Read `SETUP_GUIDE.md` for detailed explanations
- Check `README.md` for project overview
- Explore the code to understand each component
- Try customizing the UI colors or layout
- Add new features like save/share

---

## 💡 Pro Tips

1. **First time?** Use mock data (skip News API key)
2. **Testing?** Use emulator (Pixel 6, API 34)
3. **Learning?** Read code comments in files
4. **Stuck?** Check SETUP_GUIDE.md troubleshooting

---

**Total Setup Time: ~7 minutes**
**Total Test Time: ~2 minutes**

**Happy coding! 🚀**