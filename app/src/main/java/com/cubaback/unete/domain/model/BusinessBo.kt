package com.cubaback.unete.domain.model

class BusinessBo(val id : Long?,
                 val name: String?,
                 val description: String?,
                 val image : String?,
                 val dependence : List<DependencesBo>?,
                 val categories : List<CategoryBo>?)