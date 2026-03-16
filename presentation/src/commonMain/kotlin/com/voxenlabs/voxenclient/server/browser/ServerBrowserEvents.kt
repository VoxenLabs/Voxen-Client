package com.voxenlabs.voxenclient.server.browser

data class ServerBrowserEvents(
    val onLogin: (username: String, password: String) -> Unit,
    val onAddServer: (hostname: String, port: String) -> Unit,
    val onRemoveServer: (url: String) -> Unit,
    val onSetCurrentServer: (url: String) -> Unit,
)
