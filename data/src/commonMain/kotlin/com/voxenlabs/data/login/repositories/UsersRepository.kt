package com.voxenlabs.data.login.repositories

import com.voxenlabs.api.ApiClient
import com.voxenlabs.api.users.UsersApi
import com.voxenlabs.domain.users.repositories.UsersRepositoryInterface
import org.koin.core.annotation.Singleton

@Singleton
class UsersRepository(
    val usersApi: UsersApi,
) : UsersRepositoryInterface {
    override suspend fun login(
        username: String,
        password: String,
    ) {
        val response = usersApi.login(username, password)

        ApiClient.setBearerTokens(response.accessToken)
    }

    override suspend fun register(
        username: String,
        password: String,
    ) = usersApi.register(username, password)
}
