package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.BusinessModel
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.mapper.Mapper

open class ModelBusinessMapper : Mapper<BusinessModel, EntityBusiness> {

    override fun map(type: BusinessModel): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description, type.image)
    }

    override fun reverseMap(type: EntityBusiness): BusinessModel {
        return BusinessModel(type.id, type.name, type.description, type.image)
    }

}