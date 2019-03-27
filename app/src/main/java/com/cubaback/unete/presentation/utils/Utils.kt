package com.cubaback.unete.presentation.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

open class Utils{
    companion object {
        var token : String = ""
        const val DEFAULT_PHONE_NUMBER = "-1"
        const val DEFAULT_BIRTH_DATE = "0999-11-30"


        // todo: refactor all format dates functions...

        fun formatBirthDate(date : Date?) : String?{
            if(date != null){
                val formatD = "yyyy-MM-dd"
                val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
                return dateFormat.format(date)
            }
            return null
        }

        fun formatBirthDate(date : String?) : Date?{
            if(date != null){
                val formatD = "yyyy-MM-dd"
                val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
                return dateFormat.parse(date)
            }
          return null
        }


        fun timeConversion(s: String): String {
            val date =  SimpleDateFormat("hh:mm:ssa", Locale.getDefault()).parse(s)
            return  SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(date)
        }

        fun twentyFourToTuelveHour(date : String): Date{
            val newDate =  SimpleDateFormat("hh:mm:ss", Locale.getDefault()).parse(date)
            return  SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse(date)
        }

        fun formatStrDateTime(date : String?) : Date? {
            if(date != null){
                val formatD = "yyyy-MM-dd HH:mm:ss"
                val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
                return dateFormat.parse(date)
            }
            return null
        }

        fun formatStrDateTime(date : Date) : String {
            val formatD = "yyyy-MM-dd HH:mm:ss"
            val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
           return dateFormat.format(date)
        }

        /**
         * Format date to human spain date
         * */
        fun formatStrDate(date : Date) : String {
            val formatD = "d MMMM yyyy"
            val dateFormat = SimpleDateFormat(formatD, Locale("ES", "es"))
            return dateFormat.format(date)
        }

        /**
         * Compare a @param date with default date
         * @return true if two dates are equals otherwise return false
         * */
        fun compareWithDefaultDate(date : Date?) : Boolean{
            if(date != null){
                val formatD = "yyyy-MM-dd"
                val dateFormat = SimpleDateFormat(formatD, Locale.getDefault())
                return dateFormat.format(date) == DEFAULT_BIRTH_DATE
            }
            return false
        }

    }
}