package com.cubaback.unete.domain.model

import java.util.*

data class CategoryBo(val id : Long?,
                      val name : String?,
                      val description : String?,
                      val parentId : Long?,
                      val createdAt : Date?,
                      val updateAt : Date?)