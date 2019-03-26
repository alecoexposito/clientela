package com.cubaback.unete.presentation.model

import java.util.*

data class BusinessAccountView(val id : Long?,
                               val accountNumber : String?,
                               val defaultPercent : Int?,
                               val dependenceId : Long?,
                               val createdAt : Date?,
                               val updatedAt : Date?)