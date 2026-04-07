package com.vimosanan.blink.chat.domain.model

data class Conversation(
    val id: String,
    val name: String?,
    val updatedAt: String?,
    val messages: List<Message>
)