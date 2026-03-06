package com.voxenlabs.domain.server.repositories

import com.voxenlabs.domain.server.models.Server

interface ServerRepositoryInterface {
    suspend fun getStoredServers(): MutableList<Server>

    suspend fun storeServer(server: Server)

    suspend fun removeStoredServer(server: Server)
}
