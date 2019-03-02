package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.data.model.ProdServs
import com.cubaback.unete.data.model.ProdServsBo
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityProdServsMapper : Mapper<EntityProdServs, ProdServsBo>{

    constructor()

    override fun map(type: EntityProdServs): ProdServsBo {
        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: ProdServsBo): EntityProdServs {
        return EntityProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }
}