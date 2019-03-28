package com.cubaback.unete.remote.model

data class BusinessModel(val id : Long?,
                         val name: String?,
                         val description: String?,
                         val image : String?,
                         val dependences : List<DependencesModel>?,
                         val categories : List<CategoryModel>?)