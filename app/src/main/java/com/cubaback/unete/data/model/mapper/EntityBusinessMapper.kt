package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Business
import com.cubaback.unete.data.model.BusinessBo
import com.cubaback.unete.data.model.EntityBusiness
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityBusinessMapper : Mapper<EntityBusiness, BusinessBo> {
    constructor()

    override fun map(type: EntityBusiness): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }

    override fun reverseMap(type: BusinessBo): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description)
    }
}