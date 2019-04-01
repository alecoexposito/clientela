package com.cubaback.unete.domain.model

import java.util.*

class BusinessBo(val id : Long?,
                 val name: String?,
                 val description: String?,
                 val image : String?,
                 val dependence : List<DependencesBo>?,
                 val categories : List<CategoryBo>?,
                 val createdAt : Date?,
                 val updatedAt : Date?)