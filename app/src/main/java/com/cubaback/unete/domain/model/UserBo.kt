package com.cubaback.unete.domain.model

import java.util.*

data class UserBo (val id : Long?, val name : String?, val lastName : String?, val email : String?,
                   val password : String?, val token : String?, val createAt : Date?, val updatedAt : Date?)