package com.voxenlabs.dataStore

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

open class DataStore<K, V> {
    val mutex = Mutex()
    var cachedData = HashMap<K, V>()

    suspend fun add(
        key: K,
        value: V,
    ) {
        mutex.withLock {
            cachedData.put(key, value)
        }
    }

    suspend fun get(key: K): V? {
        mutex.withLock {
            return cachedData.get(key)
        }
    }

    suspend fun remove(key: K) {
        mutex.withLock {
            cachedData.remove(key)
        }
    }

    suspend fun clear() {
        mutex.withLock {
            cachedData.clear()
        }
    }
}
