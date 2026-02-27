package com.voxenlabs.data.login.api

import LoginResponse

interface UsersApiInterface {
    suspend fun login(
        username: String,
        password: String,
    ): LoginResponse

    suspend fun register(
        username: String,
        password: String,
    )
}
