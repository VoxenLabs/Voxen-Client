package com.voxenlabs.domain.server.usecases

import com.voxenlabs.domain.apiClient.usecases.SetCurrentServerHostnameUseCase
import com.voxenlabs.domain.server.models.Server
import org.koin.core.annotation.Factory

@Factory
class VerifyAndAddServerUseCase(
    val setCurrentServerHostname: SetCurrentServerHostnameUseCase,
    val getServerInfo: GetServerInfoUseCase,
    val storeServer: StoreServerUseCase,
) {
    suspend operator fun invoke(
        hostname: String,
        port: String,
    ) {
        setCurrentServerHostname(hostname, port)
        val serverInfo = getServerInfo()
        val server = Server(hostname, port, serverInfo)
        storeServer(server)
    }
}
