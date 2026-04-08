package com.vimosanan.blink.chat.presentation.chat.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.usecase.chat.ObserveConversationUseCase
import com.vimosanan.blink.chat.domain.usecase.chat.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    observeConversationUseCase: ObserveConversationUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
) : ViewModel() {

    private val conversationId: String = checkNotNull(savedStateHandle["conversationId"])

    val conversation = observeConversationUseCase(conversationId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    fun onMessageSent(message: String) {
        viewModelScope.launch {
            when (val result = sendMessageUseCase(
                SendMessageUseCase.SendMessageParams(
                    conversationId = conversationId,
                    message = message
                )
            )) {
                is OperationResult.Success -> {
                    // Message sent successfully, no action needed as the conversation flow will update automatically
                }

                is OperationResult.Error -> {
                    // Handle failure (e.g., show error message to user)
                }
            }
        }
    }
}