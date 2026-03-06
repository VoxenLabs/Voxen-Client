package com.voxenlabs.data.apiClient.repositories

import com.voxenlabs.api.ApiClient
import com.voxenlabs.domain.apiClient.repositories.ApiClientRepositoryInterface
import org.koin.core.annotation.Singleton

@Singleton
class ApiClientRepository : ApiClientRepositoryInterface {
    override fun setCurrentServerHostName(
        hostname: String,
        port: String,
    ) {
        ApiClient.baseUrl = "http://$hostname:$port"
    }
}
