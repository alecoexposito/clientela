package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.cache.model.CachedBusiness
import com.cubaback.unete.mapper.Mapper

open class CachedBusinessMapper() : Mapper<CachedBusiness, BusinessBo> {


    override fun map(type: CachedBusiness): BusinessBo {
        return BusinessBo(type.id, type.name, type.description)
    }

    override fun reverseMap(type: BusinessBo): CachedBusiness {
        return CachedBusiness(type.id, type.name, type.description)
    }
}