package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityProdServs
import com.cubaback.unete.remote.model.ProdServsModel
import com.cubaback.unete.mapper.Mapper

open class ModelProdServsMapper() : Mapper<ProdServsModel, EntityProdServs> {
    override fun map(type: ProdServsModel): EntityProdServs {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityProdServs): ProdServsModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: ProdServsModel): ProdServsBo {
//        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
//    }
//
//    override fun reverseMap(type: ProdServsBo): ProdServsModel {
//        return EntityProdServs(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
//    }
}
