package com.vimosanan.blink.chat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.vimosanan.blink.chat.data.local.entity.ConversationEntity
import com.vimosanan.blink.chat.data.local.entity.ConversationWithMessages
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversationDao {
    @Transaction
    @Query("SELECT * FROM conversations ORDER BY updated_at DESC")
    fun observeConversationsWithMessages(): Flow<List<ConversationWithMessages>>

    @Transaction
    @Query("SELECT * FROM conversations WHERE id =:conversationId")
    fun observeConversationWithMessages(conversationId: String): Flow<ConversationWithMessages?>

    @Query("SELECT * FROM conversations ORDER BY updated_at DESC")
    fun observeConversations(): Flow<List<ConversationEntity>>

    @Upsert
    suspend fun upsertConversations(conversations: List<ConversationEntity>)
}