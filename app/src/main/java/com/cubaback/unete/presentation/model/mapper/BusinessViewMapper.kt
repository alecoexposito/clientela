package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.data.model.BusinessView
import com.cubaback.unete.mapper.Mapper

class BusinessViewMapper : Mapper<BusinessBo, BusinessView> {

    override fun map(type: BusinessBo): BusinessView {
        return BusinessView(type.id, type.name, type.description)
    }

    override fun reverseMap(type: BusinessView): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }
}