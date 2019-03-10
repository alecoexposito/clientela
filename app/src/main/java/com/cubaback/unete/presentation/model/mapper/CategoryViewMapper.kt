package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.data.model.CategoryView
import com.cubaback.unete.mapper.Mapper

class CategoryViewMapper : Mapper<CategoryBo, CategoryView> {

    override fun map(type: CategoryBo): CategoryView {
        return CategoryView(type.id, type.name, type.description, type.parentId)
    }

    override fun reverseMap(type: CategoryView): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId)
    }
}