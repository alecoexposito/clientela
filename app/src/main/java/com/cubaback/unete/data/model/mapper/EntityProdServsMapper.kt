package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.domain.model.ProdServsBo
import com.cubaback.unete.mapper.Mapper

open class EntityProdServsMapper() : Mapper<EntityProdServs, ProdServsBo>() {

    //constructor()

    override fun map(type: EntityProdServs): ProdServsBo {
        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: ProdServsBo): EntityProdServs {
        return EntityProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }
}
