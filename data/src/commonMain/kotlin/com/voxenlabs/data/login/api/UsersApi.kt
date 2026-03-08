package com.voxenlabs.data.login.api

import LoginResponse
import com.voxenlabs.api.users.UsersApi
import io.ktor.client.call.body
import org.koin.core.annotation.Singleton

@Singleton
class UsersApi : UsersApiInterface {
    override suspend fun login(
        username: String,
        password: String,
    ): LoginResponse = UsersApi.login(username, password).body()

    override suspend fun register(
        username: String,
        password: String,
    ) {
        UsersApi.register(username, password)
    }
}
