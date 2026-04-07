package com.vimosanan.blink.chat.presentation.chat.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.chat.viewmodel.ChatViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = hiltViewModel()) {
    val conversations by viewModel.conversations.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ChatContent(
            conversations,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ChatContent(
    conversations: List<Conversation>,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = conversations.size.toString())
        LazyColumn {
            items(count = conversations.size) { index ->
                ConversationRow(conversation = conversations[index])
            }
        }
    }
}

@Composable
fun ConversationRow(
    conversation: Conversation
) {
    Text(
        text = conversation.id,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}