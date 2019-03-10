package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.DependencesView
import com.cubaback.unete.domain.model.DependencesBo
import com.cubaback.unete.mapper.Mapper

open class DependenceBoMapper : Mapper<DependencesBo, DependencesView> {
    constructor()

    override fun map(type: DependencesBo): DependencesView {
        return DependencesView(type.id, type.name, type.description, type.main, type.businessId)
    }

    override fun reverseMap(type: DependencesView): DependencesBo {
        return  DependencesBo(type.id, type.name, type.description, type.main, type.businessId)
    }

}
