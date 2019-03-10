package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.CategoryView
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.mapper.Mapper

open class CategoryBoMapper : Mapper<CategoryBo, CategoryView> {
    constructor()

    override fun map(type: CategoryBo): CategoryView {
        return CategoryView(type.id, type.name, type.description, type.parentId)
    }

    override fun reverseMap(type: CategoryView): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId)
    }


}