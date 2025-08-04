# 🦄 Cryptozz – Effortless Cryptocurrency Portfolio Tracker (Android Native)

**Cryptozz** is a virtual cryptocurrency portfolio tracker that lets you explore and manage a mock portfolio using real-time data from the crypto market. Built with **Jetpack Compose** and powered by [CoinGecko's](https://www.coingecko.com/en/api) API, it provides insights into over 20 major cryptocurrencies with a smooth, modern native Android experience.

---

## 🚀 Features

### 🔐 Authentication
- **Google Sign-In**: Log in securely using your Google account.
- **Anonymous Access**: Try out the app without signing up.

> Authentication handled via Firebase Auth.

---

### 📈 Cryptocurrency Market
- Real-time tracking of **top 20 cryptocurrencies**
- View **market cap**, **24h price change %**, and **rank**
- Sort and filter by **market cap in USD**

---

### 📊 Coin Detail View
Tap on a coin to explore its full profile:
- Coin Name, Current Price, Market Cap & Rank
- Volume, High/Low, Circulating & Max Supply
- Price & Market Cap Change in 24 hours
- Interactive Line Charts for:
  - `24h`, `1W`, `1M`, `3M`, `6M`, `1Y`, `All`

---

### ⭐ Favorites
- Save favorite coins to a personalized section
- Add or remove coins with a single tap
- Favorites stored in Firestore and tied to the authenticated user

---

## 🛠️ Tech Stack

- **Jetpack Compose** – Modern UI toolkit for native Android
- **Kotlin** – Core programming language
- **Firebase** – Auth & Firestore for persistence
- **CoinGecko API** – For real-time crypto data
- **MVVM Architecture** – Clean separation of UI, data, and business logic
- **LiveData + Coroutines** – For reactive, lifecycle-aware UI
- **WorkManager** – Handles background auto-refresh every 5 minutes

---

## 📦 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/harshit-332004/cryptozz-android.git
   cd cryptozz-android

    Open in Android Studio

    Sync Gradle and run the app on emulator or device

📌 Note

This app is for educational purposes only. No real crypto trading or transactions occur. All portfolio interactions are virtual.
📧 Contact

Harshit Gyanchandani
📧 harshitgyanchandani@gmail.com
