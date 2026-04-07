package com.vimosanan.blink.chat.data.remote.datasource

import com.vimosanan.blink.chat.data.remote.dto.ConversationDto

interface ChatRemoteDataSource {
    suspend fun fetchConversations(): List<ConversationDto>
}