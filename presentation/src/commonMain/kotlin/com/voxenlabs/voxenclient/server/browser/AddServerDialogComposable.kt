package com.voxenlabs.voxenclient.server.browser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.voxenlabs.voxenclient.utils.ScreenPreview

@Composable
fun AddServerDialog(
    onAddServer: (hostname: String, port: String, password: String) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val hostname = TextFieldState("")
    val port = TextFieldState("")
    val password = TextFieldState("")

    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            Text("Add server")
        },
        text = {
            Column {
                OutlinedTextField(
                    label = { Text("Hostname") },
                    state = hostname,
                )

                OutlinedTextField(
                    label = { Text("Port") },
                    state = port,
                )

                OutlinedSecureTextField(
                    label = { Text("Password (optional)") },
                    state = password,
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest,
                content = { Text("Cancel") },
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onAddServer(hostname.text.toString(), port.text.toString(), password.text.toString())
                },
                content = { Text("Add") },
            )
        },
    )
}

@Preview
@Composable
private fun AddServerDialogComposablePreview() = ScreenPreview {
    AddServerDialog(
        onAddServer = { _, _, _ -> },
        onDismissRequest = {},
    )
}
