package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.model.AdvertisementDataView

open class AdvertisementViewMapper : Mapper<AdvertisementBo, AdvertisementDataView>() {

    override fun map(type: AdvertisementBo): AdvertisementDataView {
        return AdvertisementDataView(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: AdvertisementDataView): AdvertisementBo {
        return AdvertisementBo(type.id, type.title, type.description, type.image, type.createdAt, type.updatedAt)
    }
}
