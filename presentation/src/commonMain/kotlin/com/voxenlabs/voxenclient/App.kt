package com.voxenlabs.voxenclient

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.voxenlabs.voxenclient.server.browser.ServerBrowser
import com.voxenlabs.voxenclient.server.browser.ServerBrowserComposablePreview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    MaterialTheme {
        ServerBrowser(koinViewModel())
    }
}
