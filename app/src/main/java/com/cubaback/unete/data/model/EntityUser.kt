package com.cubaback.unete.data.model

data class EntityUser (val id : Long, val name : String, val lastName : String, val email : String,
                       val password : String, val token : String, val createAt : String, val updatedAt : String)