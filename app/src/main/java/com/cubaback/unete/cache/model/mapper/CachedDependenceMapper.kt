package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedDependences
import com.cubaback.unete.data.model.EntityDependences
import com.cubaback.unete.mapper.Mapper

open class CachedDependenceMapper(val cachedBussinessAccountMapper: CachedBusinessAccountMapper) : Mapper<EntityDependences, CachedDependences>() {
   // constructor()

    override fun map(type: EntityDependences): CachedDependences {
        return CachedDependences(type.id, type.name, type.description, type.main, type.businessId,
                type.createdAt, type.updatedAt,
                type.account?.let { cachedBussinessAccountMapper.map(it) })
    }

    override fun reverseMap(type: CachedDependences): EntityDependences {
       return  EntityDependences(type.id, type.name, type.description, type.main, type.businessId,
               type.createdAt, type.updatedAt,
               type.account?.let { cachedBussinessAccountMapper.reverseMap(it) })
    }
}
