package com.vimosanan.blink.chat.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(
    tableName = "conversations"
)
data class ConversationEntity(
    @PrimaryKey val id: String,
    val name: String?,
    @ColumnInfo(name = "updated_at") val updatedAt: Instant?,
)
