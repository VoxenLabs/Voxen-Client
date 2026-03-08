package com.voxenlabs.voxenclient.server.browser

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal actual fun ServerGrid(
    serverBrowserViewModel: ServerBrowserViewModel,
    onServerClick: (ServerUiModel) -> Unit,
    modifier: Modifier,
) = LazyVerticalGrid(
    modifier = modifier,
    contentPadding = PaddingValues(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    columns = GridCells.Adaptive(minSize = 100.dp),
) {
    items(serverBrowserViewModel.uiState.servers) {
        ContextMenuArea(
            items = {
                listOf(
                    ContextMenuItem("Delete") {
                        serverBrowserViewModel.removeServer(it)
                    },
                )
            },
        ) {
            ServerItem(
                it,
                onClick = { onServerClick(it) },
            )
        }
    }
}
