package com.vimosanan.blink.chat.presentation.chat.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ChatContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ChatContent(modifier: Modifier = Modifier) {
    Text(
        text = "Chat Screen",
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}