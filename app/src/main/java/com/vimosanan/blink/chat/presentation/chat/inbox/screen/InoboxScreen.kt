package com.vimosanan.blink.chat.presentation.chat.inbox.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import com.vimosanan.blink.chat.presentation.chat.inbox.component.ConversationRow
import com.vimosanan.blink.chat.presentation.chat.preview.ChatPreviewData
import com.vimosanan.blink.chat.presentation.chat.inbox.viewmodel.InboxViewModel
import com.vimosanan.blink.chat.presentation.common.BlinkChatAppBar
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme

@Composable
fun InboxScreen(
    viewModel: InboxViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit = {},
) {
    val conversations by viewModel.conversations.collectAsStateWithLifecycle()

    InboxContent(
        conversations = conversations,
        onConversationClicked = onNavigate,
    )
}

@Composable
fun InboxContent(
    conversations: List<Conversation>,
    modifier: Modifier = Modifier,
    onConversationClicked: (String) -> Unit = {},
) {
    Scaffold(
        topBar = {
            BlinkChatAppBar(
                title = "Inbox (${conversations.size})",
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn {
                items(items = conversations, key = { it.id }) { conversation ->
                    ConversationRow(
                        conversation = conversation,
                        modifier = Modifier
                            .clickable {
                                onConversationClicked(conversation.id)
                            },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InboxScreenPreview() {
    BlinkChatApplicationTheme {
        InboxContent(
            conversations = ChatPreviewData.dummyConversations
        )
    }
}