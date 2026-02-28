package com.voxenlabs.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class UnsuccessfulRequestException(
    url: String,
    statusCode: HttpStatusCode,
) : Exception("Request to $url failed, status code: ${statusCode.value}")

object ApiClient {
    val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    var baseUrl: String? = null
    var accessToken: String? = null

    suspend inline fun <reified T, reified U> executeRequest(
        endpoint: String,
        method: HttpMethod,
        body: T,
    ): U {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            getHeaders()
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        validateResponse(fullUrl, response)

        return response.body()
    }

    suspend inline fun <reified T> executeRequestNoResponse(
        endpoint: String,
        method: HttpMethod,
        body: T,
    ) {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            getHeaders()
            contentType(ContentType.Application.Json)
            setBody(body)
        }

        validateResponse(fullUrl, response)
    }

    suspend inline fun <reified T> executeRequest(
        endpoint: String,
        method: HttpMethod,
    ): T {
        val fullUrl = getFullUrl(endpoint)

        val response = client.request(fullUrl) {
            this.method = method
            getHeaders()
        }

        validateResponse(fullUrl, response)

        return response.body()
    }

    @PublishedApi internal fun getFullUrl(endpoint: String): String {
        val baseUrl = baseUrl ?: throw IllegalStateException()
        return baseUrl + endpoint
    }

    @PublishedApi internal fun getHeaders(): HeadersBuilder {
        val builder = HeadersBuilder()
        accessToken?.let {
            builder.append(HttpHeaders.Authorization, "Bearer $it")
        }
        return builder
    }

    @PublishedApi internal fun validateResponse(
        url: String,
        response: HttpResponse,
    ) {
        if (response.status.value !in 200..<300) {
            throw UnsuccessfulRequestException(url, response.status)
        }
    }
}
