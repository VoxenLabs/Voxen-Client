package com.voxenlabs.voxenclient.server.browser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp

@Composable
fun LoginDialog(
    events: ServerBrowserEvents,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val username = TextFieldState("")
    val password = TextFieldState("")

    val passwordFocusRequester = remember { FocusRequester() }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            Text("Login")
        },
        text = {
            Column {
                OutlinedTextField(
                    label = { Text("Username") },
                    state = username,
                    modifier = Modifier
                        .onPreviewKeyEvent {
                            if (it.key == Key.Tab && it.type == KeyEventType.KeyDown) {
                                passwordFocusRequester.requestFocus()
                                true
                            } else {
                                false
                            }
                        },
                )

                OutlinedSecureTextField(
                    label = { Text("Password") },
                    state = password,
                    modifier = Modifier
                        .focusRequester(passwordFocusRequester)
                        .padding(bottom = 4.dp),
                )

                Text(
                    "Login failed! Please make sure to fill in a correct username and password.",
                    modifier = Modifier.alpha(0f),
                    color = Color.Red,
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
                    events.onLogin(
                        username.text.toString(),
                        password.text.toString(),
                    )
                },
                content = { Text("Login") },
            )
        },
    )
}
