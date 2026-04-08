package com.vimosanan.blink.chat.presentation.chat.inbox.state

sealed class InboxUiState {
    data object Idle : InboxUiState()
    data object Loading : InboxUiState()
    data class Error(
        val message: String,
    ) : InboxUiState()
}