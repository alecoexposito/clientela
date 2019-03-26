package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class AdvertisementModel(val id : Long?,
                              val title : String?,
                              val description : String?,
                              val image : String?,
                              @SerializedName("created_at") val createdAt : Date?,
                              @SerializedName("updated_at") val updatedAt : Date?)