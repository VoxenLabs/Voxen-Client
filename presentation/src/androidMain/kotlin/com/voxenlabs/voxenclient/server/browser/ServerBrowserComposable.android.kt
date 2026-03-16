package com.voxenlabs.voxenclient.server.browser

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal actual fun ServerGrid(
    uiState: ServerBrowserUiState,
    onServerClick: (ServerUiModel) -> Unit,
    removeServer: (ServerUiModel) -> Unit,
    modifier: Modifier,
) {
}
