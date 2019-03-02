package com.cubaback.unete.data.model

data class BusinessAccount(val id : Long,
                             val accountNumber : String,
                             val defaultPercent : Int,
                             val dependenceId : Long)