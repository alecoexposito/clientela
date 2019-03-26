package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.mapper.Mapper

open class EntityCategoryMapper : Mapper<EntityCategory, CategoryBo>() {
   // constructor()

    override fun map(type: EntityCategory): CategoryBo {
        return CategoryBo(type.id, type.name, type.description, type.parentId, type.createdAt, type.updateAt)
    }

    override fun reverseMap(type: CategoryBo): EntityCategory {
        return EntityCategory(type.id, type.name, type.description, type.parentId, type.createdAt, type.updateAt)
    }
}