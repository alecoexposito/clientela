package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ClientAccountModel(val id: Long?,
                              @SerializedName("account_model") val accountNumber :  String?,
                              @SerializedName("client_id") val clientId: Long?,
                              @SerializedName("created_at") val createdAt : Date?,
                              @SerializedName("updated_at") val updatedAt : Date?)