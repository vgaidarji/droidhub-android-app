package com.vgaidarji.droidhub.model.date

import java.time.format.DateTimeFormatter

object DateFormatter {
    fun gitHubApiResponseDate(): DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
}
