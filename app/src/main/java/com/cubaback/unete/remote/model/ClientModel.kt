package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ClientModel (val id : Long?, val phone : String?, @SerializedName("birth_date") val birthDate : Date?,
                        @SerializedName("created_at") val createdAt : Date?,  @SerializedName("updated_at") val updatedAt : Date,
                        @SerializedName("user") val user : UserModel)