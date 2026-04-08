package com.vimosanan.blink.chat.data.local.typeconverter

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class InstantConverter {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

    @TypeConverter
    fun fromInstant(instant: Instant?): String? = instant?.toString()

    @TypeConverter
    fun toInstant(value: String?): Instant? = value?.let {
        try {
            Instant.parse(it)
        } catch (e: DateTimeParseException) {
            LocalDateTime.parse(it, formatter)
                .toInstant(ZoneOffset.UTC)
        }
    }
}