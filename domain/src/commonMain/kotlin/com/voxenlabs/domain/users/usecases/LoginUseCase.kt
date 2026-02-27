package com.voxenlabs.domain.users.usecases

import com.voxenlabs.domain.users.repositories.UsersRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class LoginUseCase(
    val usersRepository: UsersRepositoryInterface,
) {
    suspend operator fun invoke(
        username: String,
        password: String,
    ) = usersRepository.login(username, password)
}
