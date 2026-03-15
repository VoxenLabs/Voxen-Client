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
import com.voxenlabs.domain.users.usecases.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ServerBrowserViewModel(
    private val setCurrentServerHostnameUseCase: SetCurrentServerHostnameUseCase,
    private val getStoredServersUseCase: GetStoredServersUseCase,
    private val storeServerUseCase: StoreServerUseCase,
    private val removeStoredServerUseCase: RemoveStoredServerUseCase,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    val uiState by mutableStateOf(ServerBrowserUiState(mutableStateListOf()))

    fun fetchServers() {
        viewModelScope.launch {
            val storedServers = getStoredServersUseCase().map {
                ServerUiModel(it.serverInfo.name, "")
            }
            uiState.servers.clear()
            uiState.servers.addAll(storedServers)
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

    fun setCurrentServer(serverUiModel: ServerUiModel) {
        /*val splitName = serverUiModel.name.split(":")
        val server = Server(splitName[0], splitName[1])
        setCurrentServerHostnameUseCase(server.hostname, server.port)*/
    }

    fun removeServer(serverUiModel: ServerUiModel) {
        /*val splitName = serverUiModel.name.split(":")
        val server = Server(splitName[0], splitName[1])
        viewModelScope.launch {
            removeStoredServerUseCase(server)
            uiState.servers.remove(serverUiModel)
        }*/
    }
}
