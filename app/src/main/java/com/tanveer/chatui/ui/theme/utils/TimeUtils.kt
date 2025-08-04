package com.tanveer.chatui.ui.theme.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.*

object TimeUtils {

    fun getCurrentTimestamp(): String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return sdf.format(Date())
    }

    fun formatTimestamp(timeMillis: Long): String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return sdf.format(Date(timeMillis))
    }
}