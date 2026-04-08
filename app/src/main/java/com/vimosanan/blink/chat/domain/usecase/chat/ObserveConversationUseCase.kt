package com.vimosanan.blink.chat.domain.usecase.chat

import com.vimosanan.blink.chat.core.di.IODispatcher
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.repository.ChatRepository
import com.vimosanan.blink.chat.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ObserveConversationUseCase @Inject constructor(
    private val repository: ChatRepository,
    @IODispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<String, Conversation?>(dispatcher) {
    override fun execute(params: String) = repository.observeConversationById(params)
}