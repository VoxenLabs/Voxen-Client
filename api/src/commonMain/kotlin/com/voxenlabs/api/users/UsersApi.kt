package com.voxenlabs.api.users

import LoginRequest
import LoginResponse
import RegisterRequest
import com.voxenlabs.api.ApiClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod

object UsersApi {
    suspend fun login(
        username: String,
        password: String,
    ): HttpResponse {
        val url = "/users/login"

        return ApiClient.executeRequest(url, HttpMethod.Post, LoginRequest(username, password))
    }

    suspend fun register(
        username: String,
        password: String,
    ): HttpResponse {
        val url = "/users/register"

        return ApiClient.executeRequest(url, HttpMethod.Post, RegisterRequest(username, password))
    }
}
