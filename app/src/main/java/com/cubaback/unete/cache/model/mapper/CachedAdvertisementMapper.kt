package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedAdvertisements
import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.mapper.Mapper

open class CachedAdvertisementMapper : Mapper<EntityAdvertisements, CachedAdvertisements>(){
    override fun map(type: EntityAdvertisements): CachedAdvertisements {
        return CachedAdvertisements(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: CachedAdvertisements): EntityAdvertisements {
        return EntityAdvertisements(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}