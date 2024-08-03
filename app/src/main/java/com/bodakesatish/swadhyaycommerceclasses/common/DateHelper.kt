package com.bodakesatish.swadhyaycommerceclasses.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateHelper {

    const val DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd"
    const val DATE_FORMAT_dd_MMM_yyyy = "dd-MMM-yyyy"

    fun getFormattedDate(date: Date, format: String = DATE_FORMAT_yyyy_MM_dd): String {
        val sdf = SimpleDateFormat(format, Locale.ENGLISH)
        return sdf.format(date)
    }



}