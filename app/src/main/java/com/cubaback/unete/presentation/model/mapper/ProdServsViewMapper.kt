package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.ProdServsBo
import com.cubaback.unete.data.model.ProdServsView
import com.cubaback.unete.mapper.Mapper

class ProdServsViewMapper : Mapper<ProdServsBo, ProdServsView> {

    override fun map(type: ProdServsBo): ProdServsView {
        return ProdServsView(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: ProdServsView): ProdServsBo {
        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }
}
