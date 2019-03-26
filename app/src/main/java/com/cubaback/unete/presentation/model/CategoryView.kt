package com.cubaback.unete.presentation.model

import java.util.*

data class CategoryView(val id : Long?,
                        val name : String?,
                        val description : String?,
                        val parentId : Long?,
                        val createdAt : Date?,
                        val updateAt : Date?)

