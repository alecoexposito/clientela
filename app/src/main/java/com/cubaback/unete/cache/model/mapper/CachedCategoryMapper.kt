package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.mapper.Mapper

open class CachedCategoryMapper : Mapper<EntityCategory, CachedCategory> {
   // constructor()

    override fun map(type: EntityCategory): CachedCategory {
        return CachedCategory(type.id, type.name, type.description, type.parentId)
    }

    override fun reverseMap(type: CachedCategory): EntityCategory {
        return EntityCategory(type.id, type.name, type.description, type.parentId)
    }
}