package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class BusinessAccountModel(val id : Long?,
                                @SerializedName("account_number") val accountNumber : String?,
                                @SerializedName("default_percent") val defaultPercent : Int?,
                                @SerializedName("dependence_id") val dependenceId : Long?,
                                @SerializedName("created_at") val createdAt : Date?,
                                @SerializedName("updated_at") val updatedAt : Date?)