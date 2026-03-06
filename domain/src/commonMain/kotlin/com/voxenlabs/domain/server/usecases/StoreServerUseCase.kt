package com.voxenlabs.domain.server.usecases

import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class StoreServerUseCase(
    val serverRepository: ServerRepositoryInterface,
) {
    suspend operator fun invoke(server: Server) {
        if (!isServerAlreadyStored(server)) {
            serverRepository.storeServer(server)
        }
    }

    private suspend fun isServerAlreadyStored(server: Server): Boolean =
        serverRepository.getStoredServers().find { it.hostname == server.hostname && it.port == server.port } != null
}
