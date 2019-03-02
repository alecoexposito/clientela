package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Business
import com.cubaback.unete.data.model.BusinessBo
import com.cubaback.unete.data.model.EntityBusiness
import org.buffer.android.boilerplate.data.mapper.Mapper

open class BusinessBoMapper : Mapper<BusinessBo, Business> {
    constructor()

    override fun map(type: BusinessBo): Business {
        return Business(type.id, type.name, type.description)
    }

    override fun reverseMap(type: Business): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }
}