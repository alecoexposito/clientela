package com.cubaback.unete.cache.model.converter

import androidx.room.TypeConverter
import java.util.*


class DateConverter {

    companion object {
        @TypeConverter
        @JvmStatic
        fun toDate(timestamp: Long?): Date? {
            return if (timestamp == null) null else Date(timestamp)
        }

        @TypeConverter
        @JvmStatic
        fun toTimestamp(date: Date?): Long? {
            return (if (date == null) null else date!!.getTime())?.toLong()
        }
    }
}