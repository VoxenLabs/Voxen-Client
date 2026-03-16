package com.voxenlabs.voxenclient

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.voxenlabs.voxenclient.server.browser.ServerBrowser
import com.voxenlabs.voxenclient.server.browser.ServerBrowserEvents
import com.voxenlabs.voxenclient.server.browser.ServerBrowserViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    MaterialTheme {
        val serverBrowserViewModel: ServerBrowserViewModel = koinViewModel()
        serverBrowserViewModel.fetchServers()

        ServerBrowser(
            uiState = serverBrowserViewModel.uiState.collectAsStateWithLifecycle().value,
            events = ServerBrowserEvents(
                onLogin = serverBrowserViewModel::login,
                onAddServer = serverBrowserViewModel::addServer,
                onRemoveServer = serverBrowserViewModel::removeServer,
                onSetCurrentServer = serverBrowserViewModel::setCurrentServer,
            ),
        )
    }
}
