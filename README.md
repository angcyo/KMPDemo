# 2025-03-31

[Jetpack Compose 使用入门](https://developer.android.google.cn/develop/ui/compose/documentation?hl=zh-cn)

[Kotlin Multiplatform](https://www.jetbrains.com/zh-cn/kotlin-multiplatform/)

[Compose Multiplatform](https://www.jetbrains.com/zh-cn/compose-multiplatform/)

[Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/)

[ComposeDemo](https://github.com/angcyo/ComposeDemo)

## Web

`Gradle` -> `Tasks` -> `other` -> `wasmJsRun`

## Desktop

`Gradle` -> `Tasks` -> `compose desktop` -> `run`


## project

### settings.gradle.kts

```groovy
rootProject.name = "KMPDemo"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":server")
include(":shared")
```

### build.gradle.kts

```groovy
plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

//--

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    id("com.android.application").version(libs.versions.agp).apply(false)
    //id("com.android.application").version("8.5.2").apply(false)
    id("com.android.library").version("8.5.2").apply(false)
    id("org.jetbrains.kotlin.plugin.compose").version("2.1.10").apply(false)
    //
    id("org.jetbrains.compose").version("1.7.3").apply(false) //diff
    id("org.jetbrains.kotlin.jvm").version("2.1.10").apply(false) //diff //desktop
    id("org.jetbrains.kotlin.multiplatform").version("2.1.10").apply(false) //diff
}
```

## app

### build.gradle.kts

```groovy
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    //
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeCompiler)
}

//--

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.plugin.compose")
  //
  id("org.jetbrains.kotlin.multiplatform") //diff
  id("org.jetbrains.compose")              //diff
}

```

---


This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop, Server.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.
