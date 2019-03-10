package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedDependences
import com.cubaback.unete.data.model.EntityDependences
import com.cubaback.unete.mapper.Mapper

open class CachedDependenceMapper() : Mapper<EntityDependences, CachedDependences> {
   // constructor()

    override fun map(type: EntityDependences): CachedDependences {
        return CachedDependences(type.id, type.name, type.description, type.main, type.businessId)
    }

    override fun reverseMap(type: CachedDependences): EntityDependences {
       return  EntityDependences(type.id, type.name, type.description, type.main, type.businessId)
    }
}
