package com.voxenlabs.domain.apiClient.repositories

fun interface ApiClientRepositoryInterface {
    fun setCurrentServerHostName(
        hostname: String,
        port: String,
    )
}
