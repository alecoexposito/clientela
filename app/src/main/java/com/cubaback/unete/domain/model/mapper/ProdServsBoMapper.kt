package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.data.model.ProdServs
import com.cubaback.unete.data.model.ProdServsBo
import org.buffer.android.boilerplate.data.mapper.Mapper

open class ProdServsBoMapper : Mapper<ProdServsBo, ProdServs>{

    constructor()

    override fun map(type: ProdServsBo): ProdServs {
        return ProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: ProdServs): ProdServsBo {
        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

}
