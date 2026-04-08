package com.vimosanan.blink.chat.domain.model

import java.time.Instant

data class Message(
    val id: String,
    val text: String?,
    val updatedAt: Instant?
)