package com.voxenlabs.api.server

import com.voxenlabs.api.ApiClient
import io.ktor.http.HttpMethod

object ServerApi {
    suspend fun getServerInfo(): GetServerInfoResponse {
        val url = "/server/info"

        return ApiClient.executeRequest(url, HttpMethod.Get)
    }
}
