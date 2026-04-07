package com.vimosanan.blink.chat.domain.usecase.chat

import com.vimosanan.blink.chat.core.di.IODispatcher
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.repository.ChatRepository
import com.vimosanan.blink.chat.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ObserveConversationsUseCase @Inject constructor(
    private val repository: ChatRepository,
    @IODispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<Conversation>>(dispatcher) {
    override fun execute(params: Unit) = repository.observerConversations()
}