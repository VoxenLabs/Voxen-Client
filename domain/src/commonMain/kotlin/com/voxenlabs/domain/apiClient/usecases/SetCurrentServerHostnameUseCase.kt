package com.voxenlabs.domain.apiClient.usecases

import com.voxenlabs.domain.apiClient.repositories.ApiClientRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class SetCurrentServerHostnameUseCase(
    val apiClientRepository: ApiClientRepositoryInterface,
) {
    operator fun invoke(
        hostname: String,
        port: String,
    ) = apiClientRepository.setCurrentServerHostName(hostname, port)
}
