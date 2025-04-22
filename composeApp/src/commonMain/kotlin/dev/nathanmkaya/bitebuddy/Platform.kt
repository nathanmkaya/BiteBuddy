package dev.nathanmkaya.bitebuddy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform