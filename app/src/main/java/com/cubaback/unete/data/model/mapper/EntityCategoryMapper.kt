package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.CategoryBo
import com.cubaback.unete.data.model.EntityCategory
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityCategoryMapper : Mapper<EntityCategory, CategoryBo> {
    constructor()

    override fun map(type: EntityCategory): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId)
    }

    override fun reverseMap(type: CategoryBo): EntityCategory {
        return EntityCategory(type.id, type.name, type.description, type.parentId)
    }
}