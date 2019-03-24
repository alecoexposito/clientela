package com.cubaback.unete.data.model

import java.util.*

data class EntityClient (val id : Long?, val phone : String?, val birthDate : Date?,
                         val createdAt : Date?, val updatedAt : Date?,
                         val user : EntityUser?)