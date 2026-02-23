package com.voxenlabs.voxenclient.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
@Suppress("ktlint:compose:modifier-missing-check")
fun ScreenPreview(content: @Composable () -> Unit) = MaterialTheme {
    Surface {
        content()
    }
}
