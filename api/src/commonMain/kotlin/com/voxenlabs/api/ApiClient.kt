package com.voxenlabs.api

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.clearAuthTokens
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json

object ApiClient {
    val client: HttpClient = HttpClient(CIO) {
        expectSuccess = true
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v("HTTP Client", null, message)
                }
            }
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
        install(Auth) {
            bearer {
                loadTokens {
                    bearerTokens
                }
            }
        }
    }.also {
        Napier.base(DebugAntilog())
    }

    var baseUrl: String? = null
    private var bearerTokens: BearerTokens? = null

    fun setBearerTokens(
        accessToken: String,
        refreshToken: String? = null,
    ) {
        bearerTokens = BearerTokens(accessToken, refreshToken)
        client.clearAuthTokens()
    }

    suspend inline fun <reified T> executeRequest(
        endpoint: String,
        method: HttpMethod,
        body: T,
    ): HttpResponse {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        return response
    }

    suspend fun executeRequest(
        endpoint: String,
        method: HttpMethod,
        parameters: Map<String, List<String>>? = null,
    ): HttpResponse {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            parameters?.let { parametersOf(it) }
        }

        return response
    }

    @PublishedApi
    internal fun getFullUrl(endpoint: String) =
        checkNotNull(baseUrl) { "BaseUrl not set; can't get full url" } + endpoint
}
