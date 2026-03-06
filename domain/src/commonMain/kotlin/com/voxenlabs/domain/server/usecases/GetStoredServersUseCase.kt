package com.voxenlabs.domain.server.usecases

import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class GetStoredServersUseCase(
    val serverRepository: ServerRepositoryInterface,
) {
    suspend operator fun invoke(): List<Server> = serverRepository.getStoredServers()
}
