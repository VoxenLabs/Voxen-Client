package com.voxenlabs.dataStore

import org.koin.core.annotation.Singleton

@Singleton
class TestDataStore : SingleKeyDataStore<Boolean>()
