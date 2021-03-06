package com.cubaback.unete.presentation.model

import java.util.*

data class UserDataView (val id : Long? = 0,
                         val name : String? = "",
                         val lastName : String? = "",
                         val email : String? = "",
                         val password : String? = "",
                         val token : String? = "",
                         val phone : String? = "",
                         val birdDate: Date? = null,
                         val isCompleted : Boolean? = false,
                         val createAt : Date? = null,
                         val updatedAt : Date? = null)