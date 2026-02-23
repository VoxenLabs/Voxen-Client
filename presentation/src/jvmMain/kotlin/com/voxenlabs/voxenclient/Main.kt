package com.voxenlabs.voxenclient

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.koin.plugin.module.dsl.startKoin
import java.awt.Dimension

fun main() {
    startKoin<MyApp>()
    application {
        Window(
            state = rememberWindowState(
                position = WindowPosition.Aligned(Alignment.Center),
            ),
            onCloseRequest = ::exitApplication,
            title = "Voxen",
        ) {
            window.minimumSize = Dimension(800, 600)
            App()
        }
    }
}
