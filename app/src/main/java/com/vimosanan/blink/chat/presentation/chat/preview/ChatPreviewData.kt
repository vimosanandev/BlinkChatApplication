package com.vimosanan.blink.chat.presentation.chat.preview

import com.vimosanan.blink.chat.domain.model.Conversation
import com.vimosanan.blink.chat.domain.model.Message
import java.time.Instant

object ChatPreviewData {
    val dummyMessage = Message(
        id = "1",
        text = "Hello, this is a message.",
        updatedAt = Instant.parse("2024-06-01T12:00:00Z")
    )
    val dummyConversation = Conversation(
        id = "1",
        name = "John Doe",
        messages = listOf(
            Message(
                id = "1",
                text = "Hey, how are you?",
                updatedAt = Instant.parse("2024-06-01T12:00:00Z")
            ),
            Message(
                id = "2",
                text = "I'm good, thanks! How about you?",
                updatedAt = Instant.parse("2024-06-01T12:05:00Z")
            )
        ),
        updatedAt = Instant.parse("2024-06-01T12:00:00Z"),
    )

    val dummyConversations = listOf(
        dummyConversation,
        dummyConversation.copy(id = "2", name = "Jane Smith"),
        dummyConversation.copy(id = "3", name = "Alice Johnson"),
    )
}