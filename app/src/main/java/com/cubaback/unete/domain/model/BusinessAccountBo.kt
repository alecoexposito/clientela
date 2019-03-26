package com.cubaback.unete.domain.model

import java.util.*

data class BusinessAccountBo(val id : Long?,
                             val accountNumber : String?,
                             val defaultPercent : Int?,
                             val dependenceId : Long?,
                             val createdAt : Date?,
                             val updatedAt : Date?)