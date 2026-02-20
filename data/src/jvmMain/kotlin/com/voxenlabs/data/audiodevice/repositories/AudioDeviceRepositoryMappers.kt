package com.voxenlabs.data.audiodevice.repositories

import com.voxenlabs.domain.audiodevice.models.AudioDevice
import dev.onvoid.webrtc.media.audio.AudioDevice as WebRTCAudioDevice

fun WebRTCAudioDevice.toDomain() = AudioDevice(descriptor, name)

fun List<WebRTCAudioDevice>.toDomain() = map { it.toDomain() }
