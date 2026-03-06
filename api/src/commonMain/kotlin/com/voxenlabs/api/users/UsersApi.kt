package com.voxenlabs.api.users

import LoginRequest
import LoginResponse
import RegisterRequest
import com.voxenlabs.api.ApiClient
import io.ktor.http.HttpMethod

object UsersApi {
    suspend fun login(
        username: String,
        password: String,
    ): LoginResponse {
        val url = "/users/login"

        return ApiClient.executeRequest(url, HttpMethod.Post, LoginRequest(username, password))
    }

    suspend fun register(
        username: String,
        password: String,
    ) {
        val url = "/users/register"

        ApiClient.executeRequestNoResponse(url, HttpMethod.Post, RegisterRequest(username, password))
    }
}
