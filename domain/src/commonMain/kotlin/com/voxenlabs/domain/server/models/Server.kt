package com.voxenlabs.domain.server.models

import kotlinx.serialization.Serializable

@Serializable
data class Server(
    val hostname: String,
    val port: String,
    val jwtToken: String? = null,
)
