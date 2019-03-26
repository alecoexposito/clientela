package com.cubaback.unete.data.model

    class EntityBusiness(val id : Long?,
                         val name: String?,
                         val description: String?,
                         val image : String?,
                         val dependence : EntityDependences? = null,
                         val categories : List<EntityCategory> ? = null)