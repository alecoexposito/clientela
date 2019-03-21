package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.cache.model.CachedBusiness
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.mapper.Mapper

open class CachedBusinessMapper() : Mapper<EntityBusiness, CachedBusiness> {



    override fun map(type: EntityBusiness): CachedBusiness {
        return CachedBusiness(type.id, type.name, type.description)
    }

    override fun reverseMap(type: CachedBusiness): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description)
    }
}