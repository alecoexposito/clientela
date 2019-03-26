package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.BusinessView
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.mapper.Mapper

open class BusinessBoMapper(private val dependenceBoMapper: DependenceBoMapper,
                            private val categoryBoMapper: CategoryBoMapper) : Mapper<BusinessBo, BusinessView>() {


    override fun map(type: BusinessBo): BusinessView {
        return BusinessView(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependenceBoMapper.map(it) },
                type.categories?.let { categoryBoMapper.map(it) })
    }

    override fun reverseMap(type: BusinessView): BusinessBo {
        return BusinessBo(type.id, type.name, type.description, type.image,
                type.dependence?.let { dependenceBoMapper.reverseMap(it) },
                type.categories?.let { categoryBoMapper.reverseMap(it) })
    }
}