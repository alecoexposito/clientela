package com.cubaback.unete.data.model

data class ProdServsBo(val id : Long, val name : String,
                       val description : String,
                       val priceMn : Double,
                       val priceCuc : Double,
                       val dependenceId : Long)