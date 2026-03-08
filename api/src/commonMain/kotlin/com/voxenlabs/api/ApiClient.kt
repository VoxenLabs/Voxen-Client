package com.voxenlabs.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.clearAuthTokens
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json

class UnsuccessfulRequestException(
    url: String,
    response: HttpResponse,
) : Exception("Request to $url failed, status code: ${response.status.value}")

object ApiClient {
    val client: HttpClient = HttpClient(CIO) {
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

        validateResponse(fullUrl, response)

        return response
    }

    suspend inline fun executeRequest(
        endpoint: String,
        method: HttpMethod,
        parameters: Map<String, List<String>>,
    ): HttpResponse {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            parametersOf(parameters)
        }

        validateResponse(fullUrl, response)

        return response
    }

    suspend inline fun executeRequest(
        endpoint: String,
        method: HttpMethod,
    ): HttpResponse {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
        }

        validateResponse(fullUrl, response)

        return response
    }

    @PublishedApi
    internal fun getFullUrl(endpoint: String): String {
        val baseUrl = baseUrl ?: throw IllegalStateException()
        return baseUrl + endpoint
    }

    @PublishedApi
    internal fun validateResponse(
        url: String,
        response: HttpResponse,
    ) {
        if (response.status.value !in 200..<300) {
            throw UnsuccessfulRequestException(url, response)
        }
    }
}
