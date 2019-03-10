package com.cubaback.unete.data.model


data class UserView (val id : Long? = 0, val name : String? = "", val lastName : String? = "", val email : String? ="",
                     val password : String? = null, val token : String? = "", val createAt : String? = "", val updatedAt : String? ="")