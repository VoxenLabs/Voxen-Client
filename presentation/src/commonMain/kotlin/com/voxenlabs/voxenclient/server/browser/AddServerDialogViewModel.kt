package com.voxenlabs.voxenclient.server.browser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voxenlabs.domain.server.usecases.VerifyAndAddServerUseCase
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class AddServerDialogViewModel(
    val verifyAndAddServer: VerifyAndAddServerUseCase,
) : ViewModel() {
    fun addServer(
        hostname: String,
        port: String,
        serverAdded: () -> Unit,
    ) {
        viewModelScope.launch {
            verifyAndAddServer(hostname, port)
            serverAdded()
        }
    }
}
