package com.voxenlabs.domain.audiodevice.usecases

import com.voxenlabs.domain.audiodevice.models.AudioDevice
import com.voxenlabs.domain.audiodevice.repositories.AudioDeviceRepositoryInterface
import org.koin.core.annotation.Factory

@Factory
class GetDefaultSpeakerUseCase(
    val audioDeviceRepository: AudioDeviceRepositoryInterface,
) {
    operator fun invoke(): AudioDevice = audioDeviceRepository.getDefaultSpeaker()
}
