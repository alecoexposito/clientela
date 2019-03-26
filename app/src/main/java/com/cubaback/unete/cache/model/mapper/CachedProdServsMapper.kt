package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.cache.model.CachedProdServs
import com.cubaback.unete.mapper.Mapper

open class CachedProdServsMapper() : Mapper<EntityProdServs, CachedProdServs>() {

    //constructor()

    override fun map(type: EntityProdServs): CachedProdServs {
        return CachedProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: CachedProdServs): EntityProdServs {
        return EntityProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }
}
