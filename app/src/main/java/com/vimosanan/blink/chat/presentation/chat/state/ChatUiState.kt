package com.vimosanan.blink.chat.presentation.chat.state

import com.vimosanan.blink.chat.domain.model.Conversation

sealed class ChatUiState {
    data object Idle : ChatUiState()
    data object Loading : ChatUiState()
    data class Error(
        val message: String,
    ) : ChatUiState()
}