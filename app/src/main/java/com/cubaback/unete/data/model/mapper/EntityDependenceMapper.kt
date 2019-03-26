package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.DependencesBo
import com.cubaback.unete.data.model.EntityDependences
import com.cubaback.unete.mapper.Mapper

open class EntityDependenceMapper(private val entityBusinessAccountMapper: EntityBusinessAccountMapper) : Mapper<EntityDependences, DependencesBo>() {
   // constructor()

    override fun map(type: EntityDependences): DependencesBo {
        return DependencesBo(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
                type.account?.let { entityBusinessAccountMapper.map(it) } )
    }

    override fun reverseMap(type: DependencesBo): EntityDependences {
       return  EntityDependences(type.id, type.name, type.description, type.main, type.businessId, type.createdAt, type.updatedAt,
               type.account?.let { entityBusinessAccountMapper.reverseMap(it) } )
    }
}
