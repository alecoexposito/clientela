package com.cubaback.unete.remote.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class CategoryModel(val id : Long?,
                         val name : String?,
                         val description : String?,
                         @SerializedName("parent_id") val parentId : Long?,
                         @SerializedName("created_at") val createdAt : Date?,
                         @SerializedName("updated_at") val updateAt : Date?)