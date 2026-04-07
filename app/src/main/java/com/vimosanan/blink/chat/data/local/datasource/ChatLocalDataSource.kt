package com.vimosanan.blink.chat.data.local.datasource

import com.vimosanan.blink.chat.data.local.entity.ConversationEntity
import com.vimosanan.blink.chat.data.local.entity.ConversationWithMessages
import com.vimosanan.blink.chat.data.local.entity.MessageEntity
import kotlinx.coroutines.flow.Flow

interface ChatLocalDataSource {
    fun observeConversations(): Flow<List<ConversationWithMessages>>

    fun observeConversationById(conversationId: String): Flow<ConversationWithMessages?>

    suspend fun upsertConversations(conversations: List<ConversationEntity>)

    suspend fun upsertMessages(messages: List<MessageEntity>)
}