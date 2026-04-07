package com.vimosanan.blink.chat.domain.usecase.chat

import com.vimosanan.blink.chat.core.di.IODispatcher
import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.repository.ChatRepository
import com.vimosanan.blink.chat.domain.usecase.base.NoParamsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SyncChatUseCase @Inject constructor(
    private val chatRepository: ChatRepository,
    @IODispatcher dispatcher: CoroutineDispatcher
) :
    NoParamsUseCase<OperationResult>(dispatcher) {
    override suspend fun execute(): OperationResult = chatRepository.syncConversations()
}
