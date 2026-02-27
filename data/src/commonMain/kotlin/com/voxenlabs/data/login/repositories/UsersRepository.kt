package com.voxenlabs.data.login.repositories

import com.voxenlabs.api.ApiClient
import com.voxenlabs.data.login.api.UsersApiInterface
import com.voxenlabs.domain.users.repositories.UsersRepositoryInterface
import org.koin.core.annotation.Singleton

@Singleton
class UsersRepository(
    val usersApi: UsersApiInterface,
) : UsersRepositoryInterface {
    override suspend fun login(
        username: String,
        password: String,
    ) {
        val response = usersApi.login(username, password)

        ApiClient.accessToken = response.accessToken
    }

    override suspend fun register(
        username: String,
        password: String,
    ) = usersApi.register(username, password)
}
