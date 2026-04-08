package com.vimosanan.blink.chat.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vimosanan.blink.chat.data.local.dao.ConversationDao
import com.vimosanan.blink.chat.data.local.dao.MessageDao
import com.vimosanan.blink.chat.data.local.entity.ConversationEntity
import com.vimosanan.blink.chat.data.local.entity.MessageEntity
import com.vimosanan.blink.chat.data.local.typeconverter.InstantConverter

@Database(
    entities = [
        ConversationEntity::class,
        MessageEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(InstantConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun conversationDao(): ConversationDao
    abstract fun messageDao(): MessageDao
}