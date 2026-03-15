package com.voxenlabs.domain.server.usecases

import com.voxenlabs.domain.server.models.ServerInfo
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class GetServerInfoUseCase(
    val serverRepository: ServerRepositoryInterface,
) {
    suspend operator fun invoke(): ServerInfo = serverRepository.getServerInfo()
}
