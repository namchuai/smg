# SMG Real Estate Listing - Online Assessment

## Overview

This Android application was developed as part of the online assessment for SMG (Swiss Marketplace Group). It displays a list of real estate properties fetched remotely, showcasing various features commonly found in modern Android applications.

## Features Implemented

*   **Property Listing:** Displays a vertical list of real estate items using Jetpack Compose `LazyColumn`.
*   **Data Display:** Each item shows:
    *   A large thumbnail image (`Coil` for loading).
    *   Property Title.
    *   Formatted Price overlayed on the bottom-left of the image (e.g., "3,000,000₣") with a distinct background and border.
    *   Formatted Address string (Street, Postal Code Locality, Region, Country) below the title.
*   **Asynchronous Loading:** Utilizes `AsyncState` (Loading, Success, Error) pattern with Kotlin Coroutines and Flow to handle data fetching and UI updates.
*   **Interactive Address:** Address text is clickable, attempting to open the property's coordinates (if available) in a map application using an Android Intent (`geo:` URI).
    *   *Note:* Requires a map application (like Google Maps) to be installed on the device/emulator.
*   **Bookmarking:** Users can tap a heart icon button on the top-right of the property image to toggle its bookmark status. The icon updates (`Favorite` / `FavoriteBorder`) to reflect the current state.
*   **Dependency Injection:** Uses Koin for managing dependencies.
*   **Modular Architecture:** The project is structured into multiple Gradle modules (e.g., `app`, `feature:listing`, `core:domain`, `core:designsystem`).

## Tech Stack & Architecture

*   **Language:** Kotlin
*   **UI Toolkit:** Jetpack Compose
*   **Architecture:** MVVM, elements of Clean Architecture (multi-module setup)
*   **Asynchronous Programming:** Kotlin Coroutines & StateFlow
*   **Dependency Injection:** Koin
*   **Image Loading:** Coil

## URL to download APK


## Setup & Build

1.  **Clone:** Clone this repository to your local machine.
2.  **Open:** Open the project in the latest stable version of Android Studio.
3.  **Sync:** Allow Gradle to sync the project dependencies.
4.  **Build Variants:**
    *   **Debug:** Select the `debug` build variant in Android Studio (`Build` > `Select Build Variant...`). This is the standard variant for development and debugging.
    *   **Release (Signed with Debug Key):** We configured the `release` variant to use the debug signing key for easier testing of release optimizations. You can build this via the terminal:
        ```bash
        ./gradlew :app:assembleRelease
        ```
        The APK will be in `app/build/outputs/apk/release/`.
5.  **Run:** Select the `app` configuration and run it on an Android emulator or physical device (API level 24+ recommended).

** Note ** The app's performance will be better with release build.
