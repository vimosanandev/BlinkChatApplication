package com.vimosanan.blink.chat.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlinkChatAppBar(
    title: String,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = false,
    onNavigateBack: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        modifier = modifier,
    )
}

@Preview(
    showBackground = true,
    name = "AppBar without Back Button"
)
@Composable
fun BlinkChatAppBarWithoutBackPreview() {
    BlinkChatApplicationTheme {
        BlinkChatAppBar(
            title = "Inbox",
            onNavigateBack = {}
        )
    }
}

@Preview(
    showBackground = true,
    name = "AppBar with Back Button"
)
@Composable
fun BlinkChatAppBarWithBackPreview() {
    BlinkChatApplicationTheme {
        BlinkChatAppBar(
            title = "John Doe",
            showBackButton = true,
            onNavigateBack = {}
        )
    }
}


