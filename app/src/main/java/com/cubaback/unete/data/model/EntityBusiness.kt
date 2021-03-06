package com.cubaback.unete.data.model

import java.util.*

class EntityBusiness(val id : Long?,
                         val name: String?,
                         val description: String?,
                         val image : String?,
                         val dependence : List<EntityDependences>? = null,
                         val categories : List<EntityCategory> ? = null,
                         val createdAt : Date?,
                         val updatedAt : Date?)