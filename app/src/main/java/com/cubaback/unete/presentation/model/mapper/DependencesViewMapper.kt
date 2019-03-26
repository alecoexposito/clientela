package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.DependencesBo
import com.cubaback.unete.presentation.model.DependencesView
import com.cubaback.unete.mapper.Mapper

class DependencesViewMapper(private val businessAccountViewMapper: BusinessAccountViewMapper) : Mapper<DependencesBo, DependencesView>() {
    override fun map(type: DependencesBo): DependencesView {
        return DependencesView(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountViewMapper.map(it) })
    }

    override fun reverseMap(type: DependencesView): DependencesBo {
        return DependencesBo(type.id, type.name, type.description, type.main,
                type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountViewMapper.reverseMap(it) })
    }
}