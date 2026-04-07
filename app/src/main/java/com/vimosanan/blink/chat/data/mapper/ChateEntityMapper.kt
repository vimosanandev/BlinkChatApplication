package com.vimosanan.blink.chat.data.mapper

import com.vimosanan.blink.chat.data.local.entity.ConversationEntity
import com.vimosanan.blink.chat.data.local.entity.ConversationWithMessages
import com.vimosanan.blink.chat.data.local.entity.MessageEntity
import com.vimosanan.blink.chat.data.remote.dto.ConversationDto
import com.vimosanan.blink.chat.data.remote.dto.MessageDto
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.model.Message

fun ConversationWithMessages.toConversation(): Conversation {
    return Conversation(
        id = conversation.id,
        name = conversation.name,
        updatedAt = conversation.updatedAt,
        messages = messages.map { it.toDomain() }
    )
}

fun ConversationDto.toEntity(): ConversationEntity {
    return ConversationEntity(
        id = id,
        name = name,
        updatedAt = updatedAt
    )
}

fun ConversationEntity.toDomain(messageEntities: List<MessageEntity>): Conversation {
    return Conversation(
        id = id,
        name = name,
        updatedAt = updatedAt,
        messages = messageEntities.map { it.toDomain() }
    )
}

fun MessageDto.toEntity(conversationId: String): MessageEntity {
    return MessageEntity(
        id = id,
        conversationId = conversationId,
        text = text,
        updatedAt = updatedAt
    )
}

fun MessageEntity.toDomain(): Message {
    return Message(
        id = id,
        text = text,
        updatedAt = updatedAt
    )
}