package com.angcyo.kmp.kmp_demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform