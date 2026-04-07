package com.vimosanan.blink.chat.domain.repository

import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.model.Conversation
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun observeConversations(): Flow<List<Conversation>>
    fun observeConversationById(conversationId: String): Flow<Conversation?>
    suspend fun syncConversations(): OperationResult
}