# BiteBuddy - Simple Calorie Tracker

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](...) <!-- TODO: Replace with actual build status badge URL -->
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) <!-- TODO: Choose and update license if different -->

A simple, no-fuss calorie tracking mobile application built with Kotlin Multiplatform, focusing on manual entry and basic trend visualization.

---

## Table of Contents

1.  [Overview](#overview)
2.  [Features (MVP)](#features-mvp)
3.  [Technology Stack](#technology-stack)
4.  [Project Structure](#project-structure)
5.  [Getting Started](#getting-started)
    *   [Prerequisites](#prerequisites)
    *   [Building & Running](#building--running)
6.  [Project Roadmap](#project-roadmap)
    *   [Phase 1: MVP (Current Focus)](#phase-1-mvp-current-focus)
    *   [Phase 2: Post-MVP Enhancements](#phase-2-post-mvp-enhancements)
    *   [Phase 3: Advanced Features](#phase-3-advanced-features)
7.  [Contributing](#contributing)
8.  [License](#license)

---

## Overview

BiteBuddy aims to solve the problem of overly complex calorie tracking apps. Many users want simple awareness of their intake without needing vast food databases, barcode scanners, or detailed macronutrient breakdowns. This app provides a streamlined experience focused solely on:

*   **Quick Manual Entry:** Log meal names and their calorie counts rapidly.
*   **Meaningful Categorization:** Use default (Breakfast, Lunch, Dinner, Snack) or create your own categories.
*   **Clear Trend Visualization:** Understand daily consumption patterns through simple graphs.

This project is built using **Kotlin Multiplatform (KMP)** with **Compose Multiplatform** for a shared UI between Android and iOS, maximizing code reuse and ensuring a consistent user experience.

---

## Features (MVP)

The initial Minimum Viable Product (MVP) focuses on delivering the core value proposition:

*   **US1: Manual Meal Logging:** Enter meal name and calorie count quickly.
*   **US2: Category Assignment:** Assign logged meals to default or custom categories.
*   **US5: Custom Category Creation:** Define personalized meal categories (e.g., "Drinks", "Post-Workout").
*   **US6: Daily Meal List:** View all meals logged for a specific day with a running daily total. Includes navigation between days.
*   **US3: Daily Calorie Trend Graph:** Visualize total daily calorie intake over time (e.g., last 7/30 days).
*   **US4: Category-Specific Trend Graphs:** View trend graphs filtered by default categories (Breakfast, Lunch, Dinner, Snack).
*   **US7: Local Data Persistence:** All logged meals and custom categories are saved locally on the device using SQLDelight.
*   **Shared UI:** A consistent user interface across Android and iOS powered by Compose Multiplatform.

---

## Technology Stack

*   **Core:** Kotlin Multiplatform (KMP)
*   **Shared UI:** Compose Multiplatform
*   **Asynchronous Programming:** Kotlin Coroutines & Flow
*   **Local Database:** SQLDelight (shared KMP persistence)
*   **Build System:** Gradle with Kotlin DSL
*   **Dependency Injection:** (Consider Koin or Kodein - TBD)
*   **Charting Library:** (Compose-compatible library - TBD, e.g., MPAndroidChart wrapper, Skia-based)
*   **Platform Specifics:**
    *   Android: Jetpack Compose, Kotlin
    *   iOS: Swift/SwiftUI (for hosting Compose view), Kotlin/Native

---

## Project Structure

The project follows a standard KMP structure:

*   `commonMain`: Contains shared Kotlin code, including:
    *   Business Logic (ViewModels, Use Cases)
    *   Repository Interfaces & Data Models
    *   SQLDelight Queries (`.sq` files) & Database Interface Implementation
    *   Shared Compose UI (`@Composable` screens and components)
*   `androidMain`: Android-specific implementations (e.g., SQLDelight driver instantiation, platform API access).
*   `iosMain`: iOS-specific implementations (e.g., SQLDelight driver instantiation, platform API access, `UIViewController` setup for Compose).
*   `android`: The Android application module, depends on `commonMain`.
*   `iosApp`: The iOS application module (Xcode project), depends on `commonMain`.

---

## Getting Started

### Prerequisites

*   JDK (Java Development Kit) - Version 11 or higher recommended.
*   Android Studio (Latest stable version recommended, with KMP plugin).
*   Xcode (Latest stable version recommended, for iOS development).
*   Kotlin Multiplatform Mobile plugin installed in Android Studio.
*   CocoaPods (for iOS dependency management, if needed).

### Building & Running

1.  **Clone the repository:**
    ```bash
    git clone git@github.com:nathanmkaya/BiteBuddy.git
    cd BiteBuddy
    ```
2.  **Open in Android Studio:** Open the root project directory in Android Studio. Let Gradle sync.
3.  **Build the project:**
    *   Use the Build menu in Android Studio, or run `./gradlew build` from the terminal.
4.  **Run on Android:**
    *   Select the `android` configuration in Android Studio.
    *   Choose an emulator or connected device.
    *   Click the "Run" button.
5.  **Run on iOS:**
    *   Select the `iosApp` configuration in Android Studio *or* open the `iosApp/iosApp.xcworkspace` file in Xcode.
    *   Choose an iOS simulator or connected device.
    *   Click the "Run" button (in Android Studio or Xcode).

---

## Project Roadmap

### Phase 1: MVP (Current Focus)

*Target Completion: Q2 2025* <!-- TODO: Set Target Quarter/Year -->

This phase focuses on delivering the core features defined in the PRD and User Stories.

*   ⌛ **Foundation:** KMP Project Setup, Build Configuration.
*   ⌛ **US7: Persistence:** SQLDelight Integration, Schema Definition (Meals, Categories), Platform Drivers.
*   ⌛ **US1 & US2: Logging:** Meal Logging Screen UI (Compose), ViewModel, Repository Integration, Category Selection (Defaults).
*   ⌛ **US6: Daily View:** Diary Screen UI, Fetching/Displaying Daily Meals, Date Navigation Logic.
*   ⌛ **US5: Custom Categories:** Category Management Screen UI, Add Category Logic, Repository Integration.
*   ⌛ **US3: Daily Graph:** Trends Screen UI, Charting Library Integration, Fetching/Displaying Daily Total Data.
*   ⌛ **US4: Category Graphs:** Filtering/Displaying Category-Specific Data on Trends Screen.
*   ⌛ **Testing:** Unit tests for ViewModels/Repositories, Basic UI testing.
*   ⌛ **Refinement:** Basic error handling, UI Polish.

*(✅ = Done, 🚧 = In Progress, ⌛ = Not Started)*

### Phase 2: Post-MVP Enhancements

*(Future - Based on feedback and capacity)*

*   **Editing/Deleting:** Allow users to edit or delete logged meals and custom categories.
*   **Search/Filter:** Basic search functionality within the daily meal list.
*   **Improved Date Navigation:** Integrate a more user-friendly calendar picker for selecting dates.
*   **Data Management:** Simple CSV export/import for backup/restore.
*   **User Settings:** Add basic settings (e.g., setting a daily calorie goal).
*   **UI/UX Polish:** Improve animations, transitions, and overall visual appeal.
*   **Accessibility:** Enhance support for screen readers and accessibility features.

### Phase 3: Advanced Features

*(Long Term Vision - Subject to change)*

*   **Cloud Sync:** Optional account system for cross-device synchronization and backup (consider privacy implications).
*   **Widget Support:** Add home screen widgets for Android and iOS showing daily progress.
*   **Advanced Reporting:** More detailed reports and insights beyond basic trends.
*   **Wear OS / watchOS App:** Simple companion app for quick logging or viewing daily totals.
*   **(Potential - Evaluate Carefully):** Barcode Scanning / Basic Food Database Integration (Note: This deviates from the core "simple manual entry" philosophy).
*   **(Potential):** Macronutrient Tracking (Optional tracking for Protein, Carbs, Fat).

---

## Contributing

Contributions are welcome! Please follow these general guidelines:

1.  **Fork** the repository.
2.  Create a new **branch** for your feature or bug fix (`git checkout -b feature/your-feature-name`).
3.  Make your changes, adhering to the existing code style.
4.  **Write tests** for your changes where applicable.
5.  Ensure the project builds and tests pass (`./gradlew build check`).
6.  **Commit** your changes (`git commit -m 'Add some feature'`).
7.  **Push** to your branch (`git push origin feature/your-feature-name`).
8.  Open a **Pull Request** against the `main` branch of this repository.
9.  Clearly describe your changes and the problem they solve in the PR description.

Please also feel free to open **Issues** for bug reports or feature requests.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. <!-- TODO: Create a LICENSE file with the chosen license text -->

---
