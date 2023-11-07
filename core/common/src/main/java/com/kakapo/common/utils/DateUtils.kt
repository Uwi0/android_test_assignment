package com.kakapo.common.utils

import arrow.core.Either
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun getDateTimeWithFormat(format: String): String {
    val now = Date()
    return SimpleDateFormat(format, Locale.getDefault()).format(now)
}

fun Long.convertToNewFormat(format: String): String {
    val instant = Instant.ofEpochMilli(this)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
    val dtf = DateTimeFormatter.ofPattern(format)
    return date.format(dtf)
}


fun Long.toCurrentDate(): String {
    val instant = Instant.ofEpochMilli(this)
    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
    val today = LocalDate.now()
    val tomorrow = today.plusDays(1)
    val yesterday = today.minusDays(1)
    val dtf = DateTimeFormatter.ofPattern("dd MMMM yyy")
    return when (date) {
        today -> "Today"
        tomorrow -> "Tomorrow"
        yesterday -> "Yesterday"
        else -> date.format(dtf)
    }
}

fun convertCurrentDateIntoNewFormat(dateFormatter: DateTimeFormat): Either<Exception, String> {
    return try {
        val currentFormat = SimpleDateFormat(dateFormatter.currentFormat, dateFormatter.locale)
        val newFormat = SimpleDateFormat(dateFormatter.newFormat, dateFormatter.locale)
        val formattedDate = currentFormat.parse(dateFormatter.dateTime)
        Either.Right(newFormat.format(formattedDate!!))
    } catch (e: Exception) {
        Either.Left(e)
    }
}

data class DateTimeFormat(
    val locale: Locale = Locale.getDefault(),
    val currentFormat: String = "dd/MM/yy",
    val newFormat: String,
    val dateTime: String
)