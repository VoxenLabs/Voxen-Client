package com.voxenlabs.voxenclient

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform