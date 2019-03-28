package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.CategoryDataView
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.mapper.Mapper

open class CategoryBoMapper : Mapper<CategoryBo, CategoryDataView>() {


    override fun map(type: CategoryBo): CategoryDataView {
        return CategoryDataView(type.id, type.name, type.description, type.parentId, type.createdAt, type.updateAt)
    }

    override fun reverseMap(type: CategoryDataView): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId, type.createdAt, type.updateAt)
    }


}