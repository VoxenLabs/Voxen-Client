package com.voxenlabs.data.server.repositories

import com.voxenlabs.data.server.api.ServerApi
import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.models.ServerInfo
import com.voxenlabs.domain.server.repositories.ServerRepositoryInterface
import eu.anifantakis.lib.ksafe.KSafe
import org.koin.core.annotation.Singleton

@Singleton
class ServerRepository(
    val kSafe: KSafe,
    val serverApi: ServerApi,
) : ServerRepositoryInterface {
    override suspend fun getServerInfo(): ServerInfo = serverApi.getServerInfo().toDomain()

    override suspend fun getStoredServers(): List<Server> = kSafe.get(SERVER_KEY, defaultValue = listOf())

    override suspend fun storeServer(server: Server) {
        val servers = getStoredServers()

        kSafe.put(SERVER_KEY, servers + server)
    }

    override suspend fun removeStoredServer(url: String) {
        val servers = getStoredServers()

        kSafe.put(SERVER_KEY, servers.filterNot { it.url == url })
    }

    companion object {
        private const val SERVER_KEY = "servers"
    }
}
