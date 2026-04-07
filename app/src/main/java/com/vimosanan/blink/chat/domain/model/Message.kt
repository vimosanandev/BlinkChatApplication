package com.vimosanan.blink.chat.domain.model

data class Message(
    val id: String,
    val text: String?,
    val updatedAt: String?
)