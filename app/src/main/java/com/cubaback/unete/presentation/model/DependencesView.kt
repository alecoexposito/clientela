package com.cubaback.unete.presentation.model

import java.util.*

data class DependencesView(val id : Long?,
                           val name : String?,
                           val description : String?,
                           val main : Boolean? = false,
                           val businessId : Long?,
                           val createdAt : Date?,
                           val updatedAt : Date?,
                           val account : BusinessAccountView?)