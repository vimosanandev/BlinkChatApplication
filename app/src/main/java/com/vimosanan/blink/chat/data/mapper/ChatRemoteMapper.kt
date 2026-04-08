package com.vimosanan.blink.chat.data.mapper

import com.vimosanan.blink.chat.data.remote.dto.ConversationDto
import com.vimosanan.blink.chat.data.remote.dto.MessageDto
import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.model.Message
import java.time.Instant

fun ConversationDto.toConversation(): Conversation {
    return Conversation(
        id = this.id,
        name = this.name,
        updatedAt = Instant.parse(this.updatedAt),
        messages = this.messages.map { it.toMessage() }
    )
}

fun MessageDto.toMessage(): Message {
    return Message(
        id = this.id,
        text = this.text,
        updatedAt = Instant.parse(this.updatedAt)
    )
}