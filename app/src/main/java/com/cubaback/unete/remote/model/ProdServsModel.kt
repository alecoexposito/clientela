package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName

data class ProdServsModel(val id : Long?, val name : String?,
                          val description : String?,
                          @SerializedName("price_mn") val priceMn : Double?,
                          @SerializedName("price_cuc") val priceCuc : Double?,
                          @SerializedName("dependence_id") val dependenceId : Long?)