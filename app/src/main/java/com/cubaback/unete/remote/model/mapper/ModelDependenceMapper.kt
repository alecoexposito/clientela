package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityDependences
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.remote.model.DependencesModel

open class ModelDependenceMapper(private val modelBusinessAccountMapper: ModelBusinessAccountMapper) : Mapper<DependencesModel, EntityDependences>() {
    override fun map(type: DependencesModel): EntityDependences {
        return EntityDependences(type.id, type.name, type.description, type.main == 0,  type.businessId, type.createdAt, type.updatedAt,
                type.businessAccount?.let { modelBusinessAccountMapper.map(it) })

    }

    override fun reverseMap(type: EntityDependences): DependencesModel {
        var main = 1
        type.main?.let {
             main = if(it) 1 else 0
        }
        return DependencesModel(type.id, type.name, type.description, main, type.createdAt, type.updatedAt, type.businessId,
                type.account?.let { modelBusinessAccountMapper.reverseMap(it) })
    }

}
