package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.BusinessModel
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.remote.JoinUsServiceFactory.API_URL

open class ModelBusinessMapper(private val modelCategoryMapper: ModelCategoryMapper,
                               private val modelDependenceMapper: ModelDependenceMapper) : Mapper<BusinessModel, EntityBusiness>() {

    override fun map(type: BusinessModel): EntityBusiness {
        return EntityBusiness(type.id, type.name, type.description, "${API_URL}uploads/business/${type.image}",
                type.dependences?.let { modelDependenceMapper.map(it) },
                type.categories?.let { modelCategoryMapper.map(it) })
    }

    override fun reverseMap(type: EntityBusiness): BusinessModel {
        return BusinessModel(type.id, type.name, type.description, type.image,
                type.dependence?.let { modelDependenceMapper.reverseMap(it) },
                type.categories?.let { modelCategoryMapper.reverseMap(it) })
    }

}