package com.vimosanan.blink.chat.presentation.chat.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vimosanan.blink.chat.BlinkChatApplication
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@Composable
fun ConversationRow(
    conversation: Conversation
) {
    Text(
        text = conversation.name ?: "",
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun ConversationRowPreview() {
    BlinkChatApplicationTheme {
        ConversationRow(
            conversation = Conversation(
                id = "1",
                name = "Conversation 1",
                messages = emptyList(),
                updatedAt = "2024-06-01T12:00:00Z"
            )
        )
    }
}