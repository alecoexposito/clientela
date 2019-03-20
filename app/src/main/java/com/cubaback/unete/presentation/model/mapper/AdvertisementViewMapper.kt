package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.model.AdvertisementView

open class AdvertisementViewMapper : Mapper<AdvertisementBo, AdvertisementView> {

    override fun map(type: AdvertisementBo): AdvertisementView {
        return AdvertisementView(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: AdvertisementView): AdvertisementBo {
        return AdvertisementBo(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}
