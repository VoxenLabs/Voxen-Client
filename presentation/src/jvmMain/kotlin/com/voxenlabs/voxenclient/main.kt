package com.voxenlabs.voxenclient

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.plugin.module.dsl.startKoin

fun main() {
    startKoin<MyApp>()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "VoxenClient",
        ) {
            App()
        }
    }
}
