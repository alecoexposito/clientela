package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedAdvertisements
import com.cubaback.unete.data.model.EntityAdvertisments
import com.cubaback.unete.mapper.Mapper

open class CachedAdvertisementMapper : Mapper<EntityAdvertisments, CachedAdvertisements>{
    override fun map(type: EntityAdvertisments): CachedAdvertisements {
        return CachedAdvertisements(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: CachedAdvertisements): EntityAdvertisments {
        return EntityAdvertisments(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}