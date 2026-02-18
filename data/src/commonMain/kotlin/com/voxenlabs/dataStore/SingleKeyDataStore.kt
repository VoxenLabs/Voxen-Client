package com.voxenlabs.dataStore

open class SingleKeyDataStore<V> {
    private object CacheKey

    private val dataStore = DataStore<CacheKey, V>()

    suspend fun add(value: V) = dataStore.add(CacheKey, value)

    suspend fun get() = dataStore.get(CacheKey)

    suspend fun clear() = dataStore.clear()
}
