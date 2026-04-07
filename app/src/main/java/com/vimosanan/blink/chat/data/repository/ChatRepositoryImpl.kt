package com.vimosanan.blink.chat.data.repository

import com.vimosanan.blink.chat.data.local.datasource.ChatLocalDataSource
import com.vimosanan.blink.chat.data.mapper.toConversation
import com.vimosanan.blink.chat.data.mapper.toEntity
import com.vimosanan.blink.chat.data.remote.datasource.ChatRemoteDataSource
import com.vimosanan.blink.chat.domain.common.OperationResult
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatLocalDataSource: ChatLocalDataSource,
    private val chatRemoteDataSource: ChatRemoteDataSource
) :
    ChatRepository {
    override fun observeConversations(): Flow<List<Conversation>> =
        chatLocalDataSource.observeConversations()
            .map { conversationWithMessagesList ->
                conversationWithMessagesList.map { conversationWithMessages ->
                    conversationWithMessages.toConversation()
                }
            }

    override fun observeConversationById(conversationId: String): Flow<Conversation?> =
        chatLocalDataSource.observeConversationById(conversationId)
            .map { conversationWithMessages ->
                conversationWithMessages?.toConversation()
            }

    override suspend fun syncConversations(): OperationResult {
        return try {
            val conversationDtos = chatRemoteDataSource.fetchConversations()
            chatLocalDataSource.upsertConversations(
                conversationDtos.map { it.toEntity() }
            )
            chatLocalDataSource.upsertMessages(
                conversationDtos.flatMap { dto ->
                    dto.messages.map { it.toEntity(dto.id) }
                }
            )
            OperationResult.Success
        } catch (e: Exception) {
            OperationResult.Error(e.toString())
        }
    }
}