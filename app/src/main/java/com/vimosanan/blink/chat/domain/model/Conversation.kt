package com.vimosanan.blink.chat.domain.model

import java.time.Instant

data class Conversation(
    val id: String,
    val name: String?,
    val updatedAt: Instant?,
    val messages: List<Message>
)