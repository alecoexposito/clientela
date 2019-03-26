package com.cubaback.unete.domain.model

import java.util.*

data class UserBo (val id : Long?,
                   val name : String?,
                   val lastName : String?,
                   val email : String?,
                   val password : String?,
                   val token : String?,
                   val phone: String?,
                   val createAt : Date?,
                   val updatedAt : Date?,
                   val birthDate: Date?,
                   val isCompleted : Boolean?)