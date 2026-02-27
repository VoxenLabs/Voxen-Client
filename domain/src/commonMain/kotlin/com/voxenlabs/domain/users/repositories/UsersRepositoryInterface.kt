package com.voxenlabs.domain.users.repositories

interface UsersRepositoryInterface {
    suspend fun login(
        username: String,
        password: String,
    )

    suspend fun register(
        username: String,
        password: String,
    )
}
