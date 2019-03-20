package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityAdvertisments
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.mapper.Mapper

class EntityAdvertisementMapper : Mapper<EntityAdvertisments, AdvertisementBo> {
    override fun map(type: EntityAdvertisments): AdvertisementBo {
        return AdvertisementBo(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: AdvertisementBo): EntityAdvertisments {
        return EntityAdvertisments(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}