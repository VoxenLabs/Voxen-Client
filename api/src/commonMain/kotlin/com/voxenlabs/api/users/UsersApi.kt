package com.voxenlabs.api.users

import LoginRequest
import LoginResponse
import RegisterRequest
import com.voxenlabs.api.ApiClient
import io.ktor.client.call.body
import io.ktor.http.HttpMethod
import org.koin.core.annotation.Singleton

@Singleton
class UsersApi {
    suspend fun login(
        username: String,
        password: String,
    ): LoginResponse = ApiClient.executeRequest(
        endpoint = "/users/login",
        method = HttpMethod.Post,
        body = LoginRequest(username, password),
    ).body()

    suspend fun register(
        username: String,
        password: String,
    ) {
        ApiClient.executeRequest(
            endpoint = "/users/register",
            method = HttpMethod.Post,
            body = RegisterRequest(username, password),
        )
    }
}
