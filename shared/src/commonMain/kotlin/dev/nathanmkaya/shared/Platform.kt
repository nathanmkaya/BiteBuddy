package dev.nathanmkaya.shared

interface Platform {
    val name: String
}

expect fun platform(): Platform