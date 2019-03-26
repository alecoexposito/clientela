package com.cubaback.unete.data.model

import java.util.*

data class EntityDependences(val id : Long?,
                             val name : String?,
                             val description : String?,
                             val main : Boolean? = false,
                             val businessId : Long?,
                             val createdAt : Date?,
                             val updatedAt : Date?,
                             val account : EntityBusinessAccount?)