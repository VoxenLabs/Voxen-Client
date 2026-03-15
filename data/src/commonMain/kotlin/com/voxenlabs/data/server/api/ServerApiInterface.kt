package com.voxenlabs.data.server.api

import com.voxenlabs.api.server.GetServerInfoResponse

interface ServerApiInterface {
    suspend fun getServerInfo(): GetServerInfoResponse
}
