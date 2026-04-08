package com.vimosanan.blink.chat.core.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

fun Instant.toFormattedDate(
    pattern: String = "MMM dd, yyyy hh:mm a",
    zoneId: ZoneId = ZoneId.systemDefault()
): String = DateTimeFormatter
    .ofPattern(pattern)
    .withZone(zoneId)
    .format(this)


fun String.toInstant(): Instant =
    try {
        Instant.parse(this)
    } catch (e: DateTimeParseException) {
        LocalDateTime.parse(this, formatter)
            .toInstant(ZoneOffset.UTC)
    }