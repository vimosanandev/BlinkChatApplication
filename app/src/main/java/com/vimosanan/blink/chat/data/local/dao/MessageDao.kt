package com.vimosanan.blink.chat.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.vimosanan.blink.chat.data.local.entity.MessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages WHERE conversation_id = :conversationId ORDER BY updated_at DESC")
    fun observerMessages(conversationId: String): Flow<List<MessageEntity>>

    @Upsert
    suspend fun upsertMessages(messages: List<MessageEntity>)

    @Upsert
    suspend fun upsertMessage(messages: MessageEntity)
}