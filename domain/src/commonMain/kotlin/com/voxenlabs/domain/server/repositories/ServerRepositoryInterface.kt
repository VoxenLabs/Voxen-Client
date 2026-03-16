package com.voxenlabs.domain.server.repositories

import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.models.ServerInfo

interface ServerRepositoryInterface {
    suspend fun getServerInfo(): ServerInfo

    suspend fun getStoredServers(): List<Server>

    suspend fun storeServer(server: Server)

    suspend fun removeStoredServer(url: String)
}
