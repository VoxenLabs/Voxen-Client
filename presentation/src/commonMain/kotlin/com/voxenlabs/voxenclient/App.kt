package com.voxenlabs.voxenclient

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.voxenlabs.domain.apiClient.usecases.SetCurrentServerHostnameUseCase
import com.voxenlabs.domain.users.usecases.LoginUseCase
import com.voxenlabs.voxenclient.server.browser.ServerBrowserComposablePreview
import kotlinx.coroutines.runBlocking
import org.koin.compose.koinInject

@Composable
@Suppress("ktlint:compose:modifier-missing-check")
fun App() {
    val loginUseCase: LoginUseCase = koinInject()
    val setCurrentServerHostnameUseCase: SetCurrentServerHostnameUseCase = koinInject()
    setCurrentServerHostnameUseCase("localhost", "5055")
    runBlocking {
        loginUseCase("admin", "Password123!")
    }

    MaterialTheme {
        ServerBrowserComposablePreview()
    }
}
