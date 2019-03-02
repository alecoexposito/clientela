package com.cubaback.unete.data.model

data class DependencesBo(val id : Long, val name : String,
                         val description : String, val main : Boolean = false,
                         val businessId : Long)