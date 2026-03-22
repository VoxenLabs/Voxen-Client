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
    val login: LoginUseCase = koinInject()
    val setCurrentServerHostnameUseCase: SetCurrentServerHostnameUseCase = koinInject()
    setCurrentServerHostnameUseCase("http://localhost", "5055")
    runBlocking {
        login("admin", "Admin123")
    }

    MaterialTheme {
        ServerBrowserComposablePreview()
    }
}
