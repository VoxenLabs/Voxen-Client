package com.voxenlabs.domain.audiodevice.repositories

import com.voxenlabs.domain.audiodevice.models.AudioDevice

interface AudioDeviceRepositoryInterface {
    fun getAvailableMicrophones(): List<AudioDevice>

    fun getAvailableSpeakers(): List<AudioDevice>

    fun getDefaultMicrophone(): AudioDevice

    fun getDefaultSpeaker(): AudioDevice
}
