package com.voxenlabs.domain.apiClient.repositories

interface ApiClientRepositoryInterface {
    fun setCurrentServerHostName(
        hostname: String,
        port: String,
    )
}
