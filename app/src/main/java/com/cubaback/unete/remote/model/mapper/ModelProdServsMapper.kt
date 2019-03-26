package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.remote.model.ProdServsModel
import com.cubaback.unete.mapper.Mapper

open class ModelProdServsMapper() : Mapper<ProdServsModel, EntityProdServs>() {
    override fun map(type: ProdServsModel): EntityProdServs {
        return EntityProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: EntityProdServs): ProdServsModel {
        return ProdServsModel(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

}
