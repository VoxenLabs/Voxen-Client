package com.voxenlabs.voxenclient.server.browser

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.voxenlabs.voxenclient.utils.ScreenPreview
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.koinInject
import voxenclient.presentation.generated.resources.Res
import voxenclient.presentation.generated.resources.compose_multiplatform
import voxenclient.presentation.generated.resources.plus

@Composable
fun ServerBrowser(
    viewModel: ServerBrowserViewModel,
    modifier: Modifier = Modifier,
) {
    var showAddServerDialog by remember { mutableStateOf(false) }
    var showLoginDialog by remember { mutableStateOf(false) }

    viewModel.fetchServers()

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddServerDialog = true },
                content = {
                    Icon(
                        imageVector = vectorResource(Res.drawable.plus),
                        contentDescription = "Add server",
                    )
                },
            )
        },
    ) {
        ServerGrid(
            viewModel,
            onServerClick = {
                viewModel.setCurrentServer(it)
                showLoginDialog = true
            },
        )

        if (showAddServerDialog) {
            AddServerDialog(
                onAddServer = { hostname, port ->
                    viewModel.addServer(hostname, port)
                    showAddServerDialog = false
                },
                onDismissRequest = { showAddServerDialog = false },
            )
        } else if (showLoginDialog) {
            LoginDialog(
                onLogin = { username, password ->
                    viewModel.login(username, password)
                },
                onDismissRequest = { showLoginDialog = false },
            )
        }
    }
}

@Composable
internal expect fun ServerGrid(
    serverBrowserViewModel: ServerBrowserViewModel,
    onServerClick: (ServerUiModel) -> Unit,
    modifier: Modifier = Modifier,
)

@Composable
internal fun ServerItem(
    serverUiModel: ServerUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val hovered = mutableInteractionSource.collectIsHoveredAsState()
    val scale = animateFloatAsState(
        targetValue = if (hovered.value) {
            1.1f
        } else {
            1.0f
        },
        animationSpec = spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessLow),
    )

    Card(
        modifier = modifier
            .hoverable(mutableInteractionSource)
            .clickable(mutableInteractionSource, null, onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = serverUiModel.name,
                modifier = Modifier
                    .graphicsLayer {
                        this.scaleX = scale.value
                        this.scaleY = scale.value
                    },
            )
            Text(serverUiModel.name, textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun ServerBrowserComposablePreview() = ScreenPreview {
    ServerBrowser(
        viewModel = koinInject(),
    )
}
