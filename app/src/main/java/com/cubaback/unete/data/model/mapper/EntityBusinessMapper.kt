package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.mapper.Mapper

open class EntityBusinessMapper() : Mapper<EntityBusiness, BusinessBo> {


    override fun map(type: EntityBusiness): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }

    override fun reverseMap(type: BusinessBo): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description)
    }
}