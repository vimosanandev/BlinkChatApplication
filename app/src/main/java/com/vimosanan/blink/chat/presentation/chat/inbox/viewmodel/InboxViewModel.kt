package com.vimosanan.blink.chat.presentation.chat.inbox.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.usecase.chat.ObserveConversationsUseCase
import com.vimosanan.blink.chat.domain.usecase.chat.SyncChatUseCase
import com.vimosanan.blink.chat.presentation.chat.inbox.state.InboxUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InboxViewModel @Inject constructor(
    private val observeConversationsUseCase: ObserveConversationsUseCase,
    private val syncChatUseCase: SyncChatUseCase,
) : ViewModel() {
    private val _syncUiState: MutableStateFlow<InboxUiState> =
        MutableStateFlow(InboxUiState.Idle)
    val syncUiState: StateFlow<InboxUiState>
        get() = _syncUiState

    val conversations: StateFlow<List<Conversation>> = observeConversationsUseCase(Unit)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    init {
        syncConversations()
    }

    private fun syncConversations() {
        viewModelScope.launch {
            _syncUiState.value = InboxUiState.Loading

            when (val result = syncChatUseCase()) {
                is OperationResult.Success -> _syncUiState.value = InboxUiState.Idle
                is OperationResult.Error -> _syncUiState.value =
                    InboxUiState.Error(message = result.error)
            }
        }
    }
}