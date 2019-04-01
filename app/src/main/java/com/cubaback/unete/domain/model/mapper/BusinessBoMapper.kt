package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.BusinessDataView
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.mapper.Mapper

open class BusinessBoMapper(private val dependenceBoMapper: DependenceBoMapper,
                            private val categoryBoMapper: CategoryBoMapper) : Mapper<BusinessBo, BusinessDataView>() {


    override fun map(type: BusinessBo): BusinessDataView {
        return BusinessDataView(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependenceBoMapper.map(it) },
                type.categories?.let { categoryBoMapper.map(it) })
    }

    override fun reverseMap(type: BusinessDataView): BusinessBo {
        return BusinessBo(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependenceBoMapper.reverseMap(it) },
                type.categories?.let { categoryBoMapper.reverseMap(it) },
                null, null)
    }
}