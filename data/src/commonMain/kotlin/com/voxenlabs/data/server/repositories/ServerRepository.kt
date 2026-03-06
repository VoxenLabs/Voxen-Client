package com.voxenlabs.data.server.repositories

import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import eu.anifantakis.lib.ksafe.KSafe
import org.koin.core.annotation.Singleton

@Singleton
class ServerRepository(
    val kSafe: KSafe,
) : ServerRepositoryInterface {
    override suspend fun getStoredServers(): MutableList<Server> = kSafe.get(SERVER_KEY, defaultValue = mutableListOf())

    override suspend fun storeServer(server: Server) {
        val servers = getStoredServers()
        servers.add(server)

        kSafe.put(SERVER_KEY, servers)
    }

    override suspend fun removeStoredServer(server: Server) {
        val servers = getStoredServers()
        servers.remove(server)

        kSafe.put(SERVER_KEY, servers)
    }

    companion object {
        private const val SERVER_KEY = "servers"
    }
}
