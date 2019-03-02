package com.cubaback.unete.data.model

data class BusinessAccountBo(val id : Long,
                             val accountNumber : String,
                             val defaultPercent : Int,
                             val dependenceId : Long)