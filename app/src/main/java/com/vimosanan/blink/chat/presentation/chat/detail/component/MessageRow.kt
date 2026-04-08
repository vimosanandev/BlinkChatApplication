package com.vimosanan.blink.chat.presentation.chat.detail.component

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
import com.vimosanan.blink.chat.domain.model.Message
import com.vimosanan.blink.chat.presentation.chat.preview.ChatPreviewData
import com.vimosanan.blink.chat.presentation.common.CircleAvatar
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@Composable
fun MessageRow(
    message: Message,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CircleAvatar(
            name = message.text ?: "",
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Column {
            Text(
                text = message.text ?: "",
            )
            Text(
                text = message.updatedAt ?: "",
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.5f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageRowPreview() {
    BlinkChatApplicationTheme {
        MessageRow(
            message = ChatPreviewData.dummyMessage
        )
    }
}