package com.vimosanan.blink.chat.data.local.datasource

import com.vimosanan.blink.chat.data.local.dao.ConversationDao
import com.vimosanan.blink.chat.data.local.dao.MessageDao
import com.vimosanan.blink.chat.data.local.entity.ConversationEntity
import com.vimosanan.blink.chat.data.local.entity.ConversationWithMessages
import com.vimosanan.blink.chat.data.local.entity.MessageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatLocalDataSourceImpl @Inject constructor(
    private val conversationDao: ConversationDao,
    private val messageDao: MessageDao
) :
    ChatLocalDataSource {
    override fun observerConversations(): Flow<List<ConversationWithMessages>> =
        conversationDao.observerConversationsWithMessages()

    override fun observeConversationById(conversationId: String): Flow<ConversationWithMessages?> =
        conversationDao.observerConversationWithMessages(conversationId)

    override suspend fun upsertConversations(conversations: List<ConversationEntity>) =
        conversationDao.upsertConversations(conversations)

    override suspend fun upsertMessages(messages: List<MessageEntity>) =
        messageDao.upsertMessages(messages)
}