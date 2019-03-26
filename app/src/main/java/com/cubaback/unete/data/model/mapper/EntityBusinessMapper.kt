package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.mapper.Mapper

open class EntityBusinessMapper(private val entityDependenceMapper: EntityDependenceMapper,
                                private val entityCategoryMapper: EntityCategoryMapper) : Mapper<EntityBusiness, BusinessBo>() {


    override fun map(type: EntityBusiness): BusinessBo {
        return BusinessBo(type.id, type.name, type.description, type.image,
                type.dependence?.let { entityDependenceMapper.map(it) },
                type.categories?.let { entityCategoryMapper.map(it) })
    }

    override fun reverseMap(type: BusinessBo): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description, type.image,
                type.dependence?.let { entityDependenceMapper.reverseMap(it) },
                type.categories?.let { entityCategoryMapper.reverseMap(it) })
    }
}