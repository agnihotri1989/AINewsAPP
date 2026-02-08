# API Keys Configuration

This file shows you exactly where to add your API keys.

---

## 🔑 Required: Gemini API Key

### How to Get:
1. Visit: https://makersuite.google.com/app/apikey
2. Sign in with Google account
3. Click "Create API Key"
4. Copy the key

### Where to Add:
**File:** `app/src/main/java/com/example/ainewsapp/MainActivity.kt`

**Line:** ~24

**Change this:**
```kotlin
val GEMINI_API_KEY = "YOUR_GEMINI_API_KEY"
```

**To this:**
```kotlin
val GEMINI_API_KEY = "AIzaSyDxxxxxxxxxxxxxxxxxxxxx"  // Your actual key
```

---

## 📰 Optional: News API Key

### How to Get:
1. Visit: https://newsapi.org/register
2. Create account with email
3. Verify email
4. Login and copy API key from dashboard

### Where to Add:
**File:** `app/src/main/java/com/example/ainewsapp/network/NewsApiService.kt`

**Line:** ~13

**Change this:**
```kotlin
private val API_KEY = "YOUR_API_KEY"
```

**To this:**
```kotlin
private val API_KEY = "abc123xxxxxxxxxxxxx"  // Your actual key
```

### Note:
You can skip this! The app includes mock news data that works without an API key.

---

## ✅ Verification

After adding keys:

1. **Gemini Key Check:**
    - Should start with "AIza"
    - Should be about 40 characters long
    - No spaces at beginning or end

2. **News API Key Check (if using):**
    - Usually 32 characters
    - Mix of letters and numbers
    - No spaces

---

## 🔒 Security Note

**IMPORTANT:** These API keys are embedded in the app source code.

For production apps:
- Store keys in `local.properties` (not tracked by Git)
- Use BuildConfig to inject keys
- Never commit API keys to public repositories

For this learning project:
- It's okay to use keys directly in code
- Just don't share your project with keys publicly
- You can regenerate keys if needed

---

## 📝 Example Configuration

Here's what the files look like after adding keys:

### MainActivity.kt
```kotlin
@Composable
fun NewsApp() {
    val viewModel: NewsViewModel = viewModel()
    
    // ✅ YOUR GEMINI KEY HERE
    val GEMINI_API_KEY = "AIzaSyD1234567890abcdefghijklmnopqrstuvwxyz"
    
    LaunchedEffect(Unit) {
        viewModel.initializeGemini(GEMINI_API_KEY)
        viewModel.fetchNews()
    }
    // ... rest of code
}
```

### NewsApiService.kt
```kotlin
class NewsApiService {
    private val client = KtorClient.client
    
    // ✅ YOUR NEWS API KEY HERE (optional)
    private val API_KEY = "abc123def456ghi789jkl012mno345pq"
    
    suspend fun getTopHeadlines(): NewsResponse {
        return try {
            client.get("https://newsapi.org/v2/top-headlines?country=us&pageSize=5&apiKey=$API_KEY")
                .body()
        } catch (e: Exception) {
            // Falls back to mock data if API fails
            getMockNews()
        }
    }
    // ... rest of code
}
```

---

## ❓ FAQ

**Q: Do I need both API keys?**
A: No, only Gemini API key is required. News API is optional.

**Q: Where do I get these keys?**
A: Gemini: https://makersuite.google.com/app/apikey
NewsAPI: https://newsapi.org/register

**Q: Are these keys free?**
A: Yes, both offer free tiers suitable for this project.

**Q: What if my key doesn't work?**
A: Double-check:
- No extra spaces
- Complete key copied
- Key is active in your account
- Internet connection working

**Q: Can I share my project with these keys?**
A: Not recommended. Remove keys before sharing or regenerate them after.

---

## 🎯 Summary

**2 Files to Edit:**
1. MainActivity.kt → Add Gemini key (REQUIRED)
2. NewsApiService.kt → Add News API key (OPTIONAL)

**That's it!** Just paste your keys and run the app.