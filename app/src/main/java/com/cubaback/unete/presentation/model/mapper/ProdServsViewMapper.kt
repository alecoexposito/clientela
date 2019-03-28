package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.ProdServsBo
import com.cubaback.unete.presentation.model.ProdServsDataView
import com.cubaback.unete.mapper.Mapper

class ProdServsViewMapper : Mapper<ProdServsBo, ProdServsDataView>() {

    override fun map(type: ProdServsBo): ProdServsDataView {
        return ProdServsDataView(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }

    override fun reverseMap(type: ProdServsDataView): ProdServsBo {
        return ProdServsBo(type.id, type.name, type.description, type.priceMn, type.priceCuc, type.dependenceId)
    }
}
