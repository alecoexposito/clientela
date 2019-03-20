package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName

data class UserModel (val id : Long?, val name : String?, @SerializedName("lastname") val lastName : String?, val email : String?,
                      val password : String?, val token : String?, val createAt : String?, val updatedAt : String?, val phone : String?,
                      @SerializedName("birth_date") val birdDate : String?)