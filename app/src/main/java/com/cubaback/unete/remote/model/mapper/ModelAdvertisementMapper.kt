package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.remote.model.AdvertisementModel

class ModelAdvertisementMapper : Mapper<AdvertisementModel, EntityAdvertisements>() {
    override fun map(type: AdvertisementModel): EntityAdvertisements {
        return EntityAdvertisements(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: EntityAdvertisements): AdvertisementModel {
        return AdvertisementModel(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}