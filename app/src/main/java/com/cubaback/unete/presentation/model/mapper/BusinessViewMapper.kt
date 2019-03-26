package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.model.BusinessView

class BusinessViewMapper(private val categoryViewMapper: CategoryViewMapper,
                         private val dependencesViewMapper: DependencesViewMapper) : Mapper<BusinessBo, BusinessView>() {

    override fun map(type: BusinessBo): BusinessView {
        return BusinessView(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependencesViewMapper.map(it) },
                type.categories?.let { categoryViewMapper.map(it) })
    }

    override fun reverseMap(type: BusinessView): BusinessBo {
        return BusinessBo(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependencesViewMapper.reverseMap(it) },
                type.categories?.let { categoryViewMapper.reverseMap(it) })
    }
}