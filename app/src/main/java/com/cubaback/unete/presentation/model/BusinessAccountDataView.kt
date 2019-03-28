package com.cubaback.unete.presentation.model

import java.util.*

data class BusinessAccountDataView(val id : Long?,
                                   val accountNumber : String?,
                                   val defaultPercent : Int?,
                                   val dependenceId : Long?,
                                   val createdAt : Date?,
                                   val updatedAt : Date?)