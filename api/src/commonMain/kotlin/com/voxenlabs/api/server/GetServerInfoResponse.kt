package com.voxenlabs.api.server

import kotlinx.serialization.Serializable

@Serializable
data class GetServerInfoResponse(
    val name: String,
    val hasLogo: Boolean,
    val createdAt: String,
    val logoUrl: String?,
)
