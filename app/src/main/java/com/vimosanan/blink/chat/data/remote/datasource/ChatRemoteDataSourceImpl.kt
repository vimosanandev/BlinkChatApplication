package com.vimosanan.blink.chat.data.remote.datasource

import android.content.Context
import com.vimosanan.blink.chat.R
import com.vimosanan.blink.chat.data.remote.dto.ConversationDto
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ChatRemoteDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) :
    ChatRemoteDataSource {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    override suspend fun fetchConversations(): List<ConversationDto> {
        // TEMPORARY: Simulate network delay and return mock data
        delay(1000)
        return readJsonFromRaw()
    }

    private fun readJsonFromRaw(): List<ConversationDto> =
        context.resources
            .openRawResource(R.raw.conversations)
            .bufferedReader()
            .use { it.readText() }
            .let { json.decodeFromString(it) }
}