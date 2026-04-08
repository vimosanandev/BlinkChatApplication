package com.vimosanan.blink.chat.domain.usecase.chat

import com.vimosanan.blink.chat.core.di.IODispatcher
import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.repository.ChatRepository
import com.vimosanan.blink.chat.domain.usecase.base.ParamsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository,
    @IODispatcher dispatcher: CoroutineDispatcher
): ParamsUseCase<SendMessageUseCase.SendMessageParams, OperationResult>(dispatcher) {
    data class SendMessageParams(
        val conversationId: String,
        val message: String
    )

    override suspend fun execute(params: SendMessageParams): OperationResult {
        return chatRepository.sendMessage(
            conversationId = params.conversationId,
            message = params.message
        )
    }
}