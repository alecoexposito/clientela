package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class BusinessModel(val id : Long?,
                         val name: String?,
                         val description: String?,
                         val image : String?,
                         val dependences : List<DependencesModel>?,
                         val categories : List<CategoryModel>?,
                         @SerializedName("created_at")val createdAt : Date?,
                         @SerializedName("updated_at")val updatedAt : Date?)