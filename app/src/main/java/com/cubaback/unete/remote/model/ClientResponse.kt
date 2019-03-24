package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName

data class ClientResponse(@SerializedName("client") val clientModel: ClientModel, @SerializedName("token") val token : String)