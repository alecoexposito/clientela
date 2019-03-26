package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(val id : Long?,
                            @SerializedName("client_account") val clientAccountId : Long?,
                            @SerializedName("business_account") val businessAccountId : Long?,
                            @SerializedName("created_at") val createdAt : String?,
                            @SerializedName("updated_at") val updatedAt : String?)