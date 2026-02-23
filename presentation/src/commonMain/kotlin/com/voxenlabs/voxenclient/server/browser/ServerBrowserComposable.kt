package com.voxenlabs.voxenclient.server.browser

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voxenlabs.voxenclient.utils.ScreenPreview
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import voxenclient.presentation.generated.resources.Res
import voxenclient.presentation.generated.resources.compose_multiplatform
import voxenclient.presentation.generated.resources.plus

@Composable
fun ServerBrowser(
    uiState: ServerBrowserUiState,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                content = {
                    Icon(
                        imageVector = vectorResource(Res.drawable.plus),
                        contentDescription = "Add server",
                    )
                },
            )
        },
    ) {

        ServerGrid(uiState.servers)

        if (showDialog) {
            AddServerDialog(
                onAddServer = { _, _, _ -> },
                onDismissRequest = { showDialog = false },
            )
        }
    }
}

@Composable
private fun ServerGrid(
    servers: List<ServerUiModel>,
    modifier: Modifier = Modifier,
) = LazyVerticalGrid(
    modifier = modifier,
    contentPadding = PaddingValues(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    columns = GridCells.Adaptive(minSize = 100.dp),
) {
    items(servers) {
        ServerItem(it)
    }
}

@Composable
private fun ServerItem(
    serverUiModel: ServerUiModel,
    modifier: Modifier = Modifier,
) = Card(
    modifier = modifier,
    colors = CardDefaults.cardColors(
        containerColor = Color.Transparent,
    ),
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = serverUiModel.name,
        )
        Text(serverUiModel.name, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun ServerBrowserComposablePreview() = ScreenPreview {
    ServerBrowser(
        uiState = ServerBrowserUiState(
            servers = listOf(
                ServerUiModel(name = "Server 1", iconUrl = ""),
                ServerUiModel(name = "Server 2", iconUrl = ""),
                ServerUiModel(name = "Server with very long name", iconUrl = ""),
                ServerUiModel(name = "Server 4", iconUrl = ""),
                ServerUiModel(name = "Server 5", iconUrl = ""),
                ServerUiModel(name = "Server 6", iconUrl = ""),
                ServerUiModel(name = "Server 7", iconUrl = ""),
                ServerUiModel(name = "Server 8", iconUrl = ""),
                ServerUiModel(name = "Server 9", iconUrl = ""),
            ),
        ),
    )
}
