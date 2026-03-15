package com.voxenlabs.data.server.api

import com.voxenlabs.api.server.GetServerInfoResponse
import com.voxenlabs.api.server.ServerApi
import org.koin.core.annotation.Singleton

@Singleton
class ServerApi : ServerApiInterface {
    override suspend fun getServerInfo(): GetServerInfoResponse = ServerApi.getServerInfo()
}
