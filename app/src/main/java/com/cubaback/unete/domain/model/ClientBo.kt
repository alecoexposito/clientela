package com.cubaback.unete.domain.model

import java.util.*

data class ClientBo (val id : Long?, val phone : String?, val birthDate : Date?,
                     val createdAt : Date?, val updatedAt : Date?, val user : UserBo?)