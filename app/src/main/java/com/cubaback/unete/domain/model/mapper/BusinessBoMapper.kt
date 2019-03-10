package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.BusinessView
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.mapper.Mapper

open class BusinessBoMapper : Mapper<BusinessBo, BusinessView> {
    constructor()

    override fun map(type: BusinessBo): BusinessView {
        return BusinessView(type.id, type.name, type.description)
    }

    override fun reverseMap(type: BusinessView): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }
}