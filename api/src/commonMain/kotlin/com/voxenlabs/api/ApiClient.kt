package com.voxenlabs.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json

object ApiClient {
    val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    var baseUrl: String? = null
    var accessToken: String? = null

    suspend inline fun <reified T, reified U> executeRequest(
        url: String,
        method: HttpMethod,
        body: T,
    ): U {
        val baseUrl = baseUrl ?: throw IllegalStateException()

        return client.request(baseUrl + url) {
            this.method = method
            getHeaders()
            setBody(body)
        }.body()
    }

    suspend inline fun <reified T> executeRequestNoResponse(
        url: String,
        method: HttpMethod,
        body: T,
    ) {
        val baseUrl = baseUrl ?: throw IllegalStateException()

        client.request(baseUrl + url) {
            this.method = method
            getHeaders()
            setBody(body)
        }
    }

    suspend inline fun <reified T> executeRequest(
        url: String,
        method: HttpMethod,
    ): T {
        val baseUrl = baseUrl ?: throw IllegalStateException()

        return client.request(baseUrl + url) {
            this.method = method
            getHeaders()
        }.body()
    }

    fun getHeaders(): HeadersBuilder {
        val builder = HeadersBuilder()
        accessToken?.let {
            builder.append(HttpHeaders.Authorization, "Bearer $it")
        }
        return builder
    }
}
