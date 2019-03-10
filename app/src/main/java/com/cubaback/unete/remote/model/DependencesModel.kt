package com.cubaback.unete.remote.model

data class DependencesModel(val id : Long?, val name : String?,
                            val description : String?, val main : Boolean? = false,
                            val businessId : Long?)