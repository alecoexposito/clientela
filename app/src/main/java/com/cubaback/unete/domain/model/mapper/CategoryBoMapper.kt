package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Category
import com.cubaback.unete.data.model.CategoryBo
import org.buffer.android.boilerplate.data.mapper.Mapper

open class CategoryBoMapper : Mapper<CategoryBo, Category> {
    constructor()

    override fun map(type: CategoryBo): Category {
        return Category(type.id, type.name, type.description, type.parentId)
    }

    override fun reverseMap(type: Category): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId)
    }


}