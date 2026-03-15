package com.voxenlabs.domain.server.models

import kotlinx.serialization.Serializable

@Serializable
data class ServerInfo(
    val name: String,
    val logoUrl: String?,
)
