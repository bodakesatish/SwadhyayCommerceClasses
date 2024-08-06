package com.bodakesatish.swadhyaycommerceclasses.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateHelper {

    const val DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd"
    const val DATE_FORMAT_dd_MMM_yyyy = "dd-MMM-yyyy"

    fun getFormattedDate(date: Date, format: String = DATE_FORMAT_yyyy_MM_dd): String {
        val sdf = SimpleDateFormat(format, Locale.ENGLISH)
        return sdf.format(date)
    }

    fun getFormattedTime(date: Date, format: String = DATE_FORMAT_yyyy_MM_dd): String {
        val sdf = SimpleDateFormat(format, Locale.ENGLISH)
        return sdf.format(date)
    }


    // Helper function to format time
    fun formatTime(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val amPm = if (hour < 12) "AM" else "PM"
        val hourIn12HourFormat = (hour % 12).let { if (it == 0) 12 else it }
        return String.format("%02d:%02d %s", hourIn12HourFormat, minute, amPm)
    }


}