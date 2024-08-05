# droidhub-android-app

[![Build/Test](https://github.com/vgaidarji/droidhub-android-app/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/vgaidarji/droidhub-android-app/actions/workflows/main.yml)

<img src="/screenshots/app-showcase.gif" align="right" width="280">

Sample GitHub Android application built with [Jetpack Compose](https://developer.android.com/develop/ui/compose).
GitHub [REST API](https://docs.github.com/en/rest) and [GraphQL API](https://docs.github.com/en/graphql) used to fetch different information from GitHub.
This is because GitHub doesn't expose all data via REST API and GraphQL API version is more rich.

Main building blocks
- [Kotlin](https://kotlinlang.org/) 
- [Gradle (Kotlin DSL)](https://docs.gradle.org/current/userguide/kotlin_dsl.html) for build scripts
- [Gradle version catalogs (.toml)](https://developer.android.com/build/migrate-to-catalogs) for dependencies management  
- [MVVM architecture](https://developer.android.com/topic/architecture) with Unidirectional Data Flow (UDF)
- [Modularization](https://developer.android.com/topic/modularization/patterns) for clear separation of concerns and layered architecture
- [Jetpack Compose](https://developer.android.com/develop/ui/compose) for declarative UI
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for concurrency
- [Material](https://developer.android.com/develop/ui/views/theming/look-and-feel) / [Material 3](https://developer.android.com/jetpack/androidx/releases/compose-material3) for design
- [Compose Navigation](https://developer.android.com/develop/ui/compose/navigation) for navigation between compose screens
- [Retrofit](https://square.github.io/retrofit/) / [Apollo GraphQL](https://www.apollographql.com/docs/kotlin/) for API requests
- [Dagger](https://developer.android.com/training/dependency-injection/dagger-android) / [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
- [Coil](https://coil-kt.github.io/coil/) for image loading

# Project configuration

GitHub requires personal access token to access the API ([link](https://docs.github.com/en/rest/authentication/authenticating-to-the-rest-api?apiVersion=2022-11-28#authenticating-with-a-personal-access-token)).

Make sure `GITHUB_API_TOKEN` variable is set in `local.properties` file for GitHub API to work.
Also, to change the default GitHub user to be used in app change `GITHUB_USER_NAME` in `local.properties`.

# License
-------

    Copyright 2024 Veaceslav Gaidarji

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
