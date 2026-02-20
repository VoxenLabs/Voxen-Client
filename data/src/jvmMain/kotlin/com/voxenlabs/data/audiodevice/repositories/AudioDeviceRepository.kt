package com.voxenlabs.data.audiodevice.repositories

import com.voxenlabs.domain.audiodevice.models.AudioDevice
import com.voxenlabs.domain.audiodevice.repositories.AudioDeviceRepositoryInterface
import dev.onvoid.webrtc.media.MediaDevices
import org.koin.core.annotation.Singleton

@Singleton
class AudioDeviceRepository : AudioDeviceRepositoryInterface {
    override fun getAvailableMicrophones() = MediaDevices.getAudioCaptureDevices().toDomain()

    override fun getAvailableSpeakers() = MediaDevices.getAudioRenderDevices().toDomain()

    override fun getDefaultMicrophone() = MediaDevices.getDefaultAudioCaptureDevice().toDomain()

    override fun getDefaultSpeaker() = MediaDevices.getDefaultAudioRenderDevice().toDomain()
}
