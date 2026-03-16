package com.voxenlabs.voxenclient.server.browser

import com.voxenlabs.domain.server.models.Server

fun Server.mapToUiModel() = ServerUiModel("$hostname:$port", serverInfo.name, "")

fun List<Server>.mapToUiModel() = map { it.mapToUiModel() }
