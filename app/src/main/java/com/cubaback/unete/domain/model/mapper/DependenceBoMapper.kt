package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.DependencesView
import com.cubaback.unete.domain.model.DependencesBo
import com.cubaback.unete.mapper.Mapper

open class DependenceBoMapper(private val businessAccountBoMapper: BusinessAccountBoMapper) : Mapper<DependencesBo, DependencesView>() {

    override fun map(type: DependencesBo): DependencesView {
        return DependencesView(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountBoMapper.map(it) })
    }

    override fun reverseMap(type: DependencesView): DependencesBo {
        return  DependencesBo(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountBoMapper.reverseMap(it) })
    }

}
