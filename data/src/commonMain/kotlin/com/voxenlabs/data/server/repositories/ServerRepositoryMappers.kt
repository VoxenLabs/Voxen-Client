package com.voxenlabs.data.server.repositories

import com.voxenlabs.api.server.GetServerInfoResponse
import com.voxenlabs.domain.server.models.ServerInfo

fun GetServerInfoResponse.toDomain() = ServerInfo(name, logoUrl)
