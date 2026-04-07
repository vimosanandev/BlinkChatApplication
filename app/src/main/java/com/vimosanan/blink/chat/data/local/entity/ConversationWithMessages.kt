package com.vimosanan.blink.chat.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ConversationWithMessages(
    @Embedded val conversation: ConversationEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "conversation_id",
    )
    val messages: List<MessageEntity>,
)
