package com.voxenlabs.data.audiodevice.repositories

import com.voxenlabs.domain.audiodevice.models.AudioDevice

fun dev.onvoid.webrtc.media.audio.AudioDevice.mapToModel(): AudioDevice = AudioDevice(descriptor, name)

fun List<dev.onvoid.webrtc.media.audio.AudioDevice>.mapToModels(): List<AudioDevice> = map { it.mapToModel() }
