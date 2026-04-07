package com.vimosanan.blink.chat.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
{
	"id": ID,
    "text": "lorem ipsum" // Message content
    "last_updated": "Date" // Use to sort messages
}
 */
@Serializable
data class MessageDto(
    @SerialName("id") val id: String,
    @SerialName("text") val text: String?,
    @SerialName("last_updated") val updatedAt: String?
)