package com.voxenlabs.domain.server.usecases

import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class RemoveStoredServerUseCase(
    val serverRepository: ServerRepositoryInterface,
) {
    suspend operator fun invoke(url: String) = serverRepository.removeStoredServer(url)
}
