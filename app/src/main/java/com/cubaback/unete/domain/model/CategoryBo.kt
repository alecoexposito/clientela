package com.cubaback.unete.data.model

data class CategoryBo(val id : Long, val name : String,
                      val description : String,
                      val parentId : Long)