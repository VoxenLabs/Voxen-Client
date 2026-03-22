package com.voxenlabs.data

import com.voxenlabs.api.ApiModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module

@Module(includes = [ApiModule::class])
@ComponentScan("com.voxenlabs.data")
@Configuration
class DataModule
