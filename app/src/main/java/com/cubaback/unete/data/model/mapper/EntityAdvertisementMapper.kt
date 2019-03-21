package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.mapper.Mapper

class EntityAdvertisementMapper : Mapper<EntityAdvertisements, AdvertisementBo> {
    override fun map(type: EntityAdvertisements): AdvertisementBo {
        return AdvertisementBo(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: AdvertisementBo): EntityAdvertisements {
        return EntityAdvertisements(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}