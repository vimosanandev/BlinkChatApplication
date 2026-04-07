package com.vimosanan.blink.chat.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
{
    "id": ID,
    "name": "lorem ipsum" // Conversation name
	"last_updated": "Date" // Use to sort conversation list
	"messages": [
        {
		"id": ID,
		"text": "lorem ipsum" // Message content
		"last_updated": "Date" // Use to sort messages
	    }
	]
}
*/
@Serializable
data class ConversationDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("last_updated") val updatedAt: String,
    @SerialName("messages") val messages: List<MessageDto>
)