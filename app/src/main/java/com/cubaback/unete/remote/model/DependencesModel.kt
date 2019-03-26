package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class DependencesModel(val id : Long?,
                            val name : String?,
                            val description : String?,
                            val main : Int? = 0,
                            @SerializedName("created_at") val createdAt : Date?,
                            @SerializedName("updated_at") val updatedAt : Date?,
                            @SerializedName("business_id") val businessId : Long?,
                            @SerializedName("account") val businessAccount : BusinessAccountModel?)