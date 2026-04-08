package com.vimosanan.blink.chat.presentation.chat.detail.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.chat.detail.component.MessageRow
import com.vimosanan.blink.chat.presentation.chat.detail.viewmodel.MessageViewModel
import com.vimosanan.blink.chat.presentation.chat.preview.ChatPreviewData
import com.vimosanan.blink.chat.presentation.common.BlinkChatAppBar
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@Composable
fun MessageScreen(
    viewModel: MessageViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {},
) {
    val conversation by viewModel.conversation.collectAsStateWithLifecycle()

    MessageContent(conversation, onBackPressed)
}

@Composable
fun MessageContent(
    conversation: Conversation?,
    onBackPressed: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            BlinkChatAppBar(
                title = conversation?.name ?: "Conversation",
                showBackButton = true,
                onNavigateBack = onBackPressed,
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            items(
                items = conversation?.messages ?: emptyList(),
                key = { it.id }
            ) {
                MessageRow(message = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {
    BlinkChatApplicationTheme {
        MessageContent(conversation = ChatPreviewData.dummyConversation)
    }
}