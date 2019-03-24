package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserModel (val id : Long?, val name : String?, @SerializedName("lastname") val lastName : String?, val email : String?,
                      val password : String?, val token : String?, val createAt : Date?, val updatedAt : Date?, val phone : String?,
                      @SerializedName("birth_date") val birdDate : String?)