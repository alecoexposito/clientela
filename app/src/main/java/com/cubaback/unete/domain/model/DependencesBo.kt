package com.cubaback.unete.domain.model

import java.util.*

data class DependencesBo(val id : Long?,
                         val name : String?,
                         val description : String?,
                         val main : Boolean? = false,
                         val businessId : Long?,
                         val createdAt : Date?,
                         val updatedAt : Date?,
                         val account : BusinessAccountBo?)