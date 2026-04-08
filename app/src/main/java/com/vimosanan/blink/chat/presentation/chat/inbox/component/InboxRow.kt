package com.vimosanan.blink.chat.presentation.chat.inbox.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@Composable
fun ConversationRow(
    conversation: Conversation,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = conversation.name ?: "",
        )
        Text(
            text = conversation.updatedAt ?: "",
            fontSize = 12.sp,
            color = Color.Black.copy(alpha = 0.5f),
        )
    }
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