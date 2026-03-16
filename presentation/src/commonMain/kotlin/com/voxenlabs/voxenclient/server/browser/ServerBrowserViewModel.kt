package com.voxenlabs.voxenclient.server.browser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voxenlabs.domain.apiClient.usecases.SetCurrentServerHostnameUseCase
import com.voxenlabs.domain.server.models.Server
import com.voxenlabs.domain.server.usecases.GetStoredServersUseCase
import com.voxenlabs.domain.server.usecases.RemoveStoredServerUseCase
import com.voxenlabs.domain.server.usecases.StoreServerUseCase
import com.voxenlabs.domain.server.usecases.VerifyAndAddServerUseCase
import com.voxenlabs.domain.users.usecases.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ServerBrowserViewModel(
    private val setCurrentServerHostnameUseCase: SetCurrentServerHostnameUseCase,
    private val getStoredServersUseCase: GetStoredServersUseCase,
    private val storeServerUseCase: StoreServerUseCase,
    private val removeStoredServerUseCase: RemoveStoredServerUseCase,
    private val verifyAndAddServer: VerifyAndAddServerUseCase,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ServerBrowserUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    fun fetchServers() {
        viewModelScope.launch {
            val storedServers = getStoredServersUseCase().mapToUiModel()
            _uiState.update { it.copy(servers = storedServers) }
            print(storedServers)
        }
    }

    fun login(
        username: String,
        password: String,
    ) {
        viewModelScope.launch {
            loginUseCase(username, password)
        }
    }

    fun setCurrentServer(url: String) {
        // setCurrentServerHostnameUseCase(serverUiModel.hostname, serverUiModel.port)
    }

    fun addServer(
        hostname: String,
        port: String,
    ) {
        viewModelScope.launch {
            verifyAndAddServer(hostname, port)
        }
    }

    fun removeServer(url: String) {
        viewModelScope.launch {
            removeStoredServerUseCase(url)
            fetchServers()
        }
    }
}
