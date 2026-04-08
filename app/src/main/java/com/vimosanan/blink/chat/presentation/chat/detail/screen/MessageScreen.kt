package com.vimosanan.blink.chat.presentation.chat.detail.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.presentation.chat.detail.component.MessageBottomTextField
import com.vimosanan.blink.chat.presentation.chat.detail.component.MessageRow
import com.vimosanan.blink.chat.presentation.chat.detail.viewmodel.MessageViewModel
import com.vimosanan.blink.chat.presentation.chat.preview.ChatPreviewData
import com.vimosanan.blink.chat.presentation.common.BlinkChatAppBar
import com.vimosanan.blink.chat.presentation.ui.theme.BlinkChatApplicationTheme
import kotlinx.coroutines.delay

@Composable
fun MessageScreen(
    viewModel: MessageViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {},
) {
    val conversation by viewModel.conversation.collectAsStateWithLifecycle()

    MessageContent(
        conversation,
        onMessageSent = viewModel::onMessageSent,
        onBackPressed = onBackPressed,
    )
}

@Composable
fun MessageContent(
    conversation: Conversation?,
    onMessageSent: (String) -> Unit = {},
    onBackPressed: () -> Unit = {},
) {
    val listState = rememberLazyListState()
    val messages = conversation?.messages ?: emptyList()

    val keyboardOpen by rememberUpdatedState(WindowInsets.ime.getBottom(LocalDensity.current) > 0)

    LaunchedEffect(keyboardOpen, messages.size) {
        if (messages.isNotEmpty()) {
            delay(100)
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    Scaffold(
        topBar = {
            BlinkChatAppBar(
                title = conversation?.name ?: "Conversation",
                showBackButton = true,
                onNavigateBack = onBackPressed,
            )
        },
        bottomBar = {
            MessageBottomTextField(
                modifier = Modifier.imePadding(),
                onMessageSent,
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = innerPadding
        ) {
            items(
                items = messages,
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