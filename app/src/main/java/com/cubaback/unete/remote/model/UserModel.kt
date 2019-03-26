package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserModel (val id : Long?,
                      val name : String?,
                      @SerializedName("lastname") val lastName : String?,
                      val email : String?,
                      val password : String?,
                      val token : String?,
                      @SerializedName("created_at") val createAt : Date?,
                      @SerializedName("updated_at") val updatedAt : Date?,
                      val phone : String?,
                      @SerializedName("birth_date") val birdDate : String?)