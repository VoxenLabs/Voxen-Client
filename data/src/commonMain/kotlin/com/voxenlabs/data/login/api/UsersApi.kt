package com.voxenlabs.data.login.api

import LoginResponse
import com.voxenlabs.api.users.UsersApi
import org.koin.core.annotation.Singleton

@Singleton
class UsersApi : UsersApiInterface {
    override suspend fun login(
        username: String,
        password: String,
    ): LoginResponse = UsersApi.login(username, password)

    override suspend fun register(
        username: String,
        password: String,
    ) = UsersApi.register(username, password)
}
