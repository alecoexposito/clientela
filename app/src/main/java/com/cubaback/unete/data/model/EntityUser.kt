package com.cubaback.unete.data.model

import java.util.*

data class EntityUser (val id : Long?, val name : String?, val lastName : String?, val email : String?,
                       val password : String?, val phone : String?, val birthDate : Date? ,val token : String?, val createAt : Date?, val updatedAt : Date?)