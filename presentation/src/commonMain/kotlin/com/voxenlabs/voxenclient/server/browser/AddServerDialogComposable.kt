package com.voxenlabs.voxenclient.server.browser

import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.voxenlabs.voxenclient.utils.ScreenPreview

@Composable
fun AddServerDialog(
    events: ServerBrowserEvents,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val hostname = TextFieldState("")
    val port = TextFieldState("")

    val portFocusRequester = remember { FocusRequester() }

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
                    modifier = Modifier
                        .onPreviewKeyEvent {
                            if (it.key == Key.Tab && it.type == KeyEventType.KeyDown) {
                                portFocusRequester.requestFocus()
                                true
                            } else {
                                false
                            }
                        },
                )

                OutlinedTextField(
                    label = { Text("Port") },
                    state = port,
                    modifier = Modifier
                        .focusRequester(portFocusRequester),
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
                    events.onAddServer(hostname.text.toString(), port.text.toString())
                },
                content = { Text("Add") },
            )
        },
    )
}

/*@Preview
@Composable
private fun AddServerDialogComposablePreview() = ScreenPreview {
    AddServerDialog(
        onAddServer = { _, _ -> },
        onDismissRequest = {},
    )
}
*/
