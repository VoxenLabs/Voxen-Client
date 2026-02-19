package com.voxenlabs.data.audiodevice.repositories

import com.voxenlabs.domain.audiodevice.models.AudioDevice
import com.voxenlabs.domain.audiodevice.repositories.AudioDeviceRepositoryInterface
import dev.onvoid.webrtc.media.MediaDevices
import org.koin.core.annotation.Singleton

@Singleton
class AudioDeviceRepository : AudioDeviceRepositoryInterface {
    override fun getAvailableMicrophones(): List<AudioDevice> = MediaDevices.getAudioCaptureDevices().mapToModels()

    override fun getAvailableSpeakers(): List<AudioDevice> = MediaDevices.getAudioRenderDevices().mapToModels()

    override fun getDefaultMicrophone(): AudioDevice = MediaDevices.getDefaultAudioCaptureDevice().mapToModel()

    override fun getDefaultSpeaker(): AudioDevice = MediaDevices.getDefaultAudioRenderDevice().mapToModel()
}
