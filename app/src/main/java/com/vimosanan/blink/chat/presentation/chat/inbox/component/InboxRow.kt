package com.vimosanan.blink.chat.presentation.chat.inbox.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vimosanan.blink.chat.core.util.toFormattedDate
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.common.CircleAvatar
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme
import java.time.Instant

@Composable
fun ConversationRow(
    conversation: Conversation,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CircleAvatar(
            name = conversation.name ?: "",
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Column {
            Text(
                text = conversation.name ?: "",
            )
            Text(
                text = conversation.updatedAt?.toFormattedDate() ?: "",
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.5f),
            )
        }
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
                updatedAt = Instant.now()
            )
        )
    }
}