plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    /*alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false*/

    id("com.android.application").version(libs.versions.agp).apply(false)
    //id("com.android.application").version("8.5.2").apply(false)
    id("com.android.library").version("8.5.2").apply(false)

    id("org.jetbrains.compose").version("1.7.3").apply(false)
    id("org.jetbrains.kotlin.plugin.compose").version("2.1.10").apply(false)

    id("org.jetbrains.kotlin.jvm").version("2.1.10").apply(false)
    id("org.jetbrains.kotlin.multiplatform").version("2.1.10").apply(false)
}