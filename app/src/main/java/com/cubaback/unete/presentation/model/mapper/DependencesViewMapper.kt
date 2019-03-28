package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.DependencesBo
import com.cubaback.unete.presentation.model.DependencesDataView
import com.cubaback.unete.mapper.Mapper

class DependencesViewMapper(private val businessAccountViewMapper: BusinessAccountViewMapper) : Mapper<DependencesBo, DependencesDataView>() {
    override fun map(type: DependencesBo): DependencesDataView {
        return DependencesDataView(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountViewMapper.map(it) })
    }

    override fun reverseMap(type: DependencesDataView): DependencesBo {
        return DependencesBo(type.id, type.name, type.description, type.main,
                type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { businessAccountViewMapper.reverseMap(it) })
    }
}