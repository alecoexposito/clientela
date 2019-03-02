package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.DependencesBo
import com.cubaback.unete.data.model.EntityDependences
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityDependenceMapper : Mapper<EntityDependences, DependencesBo>{
    constructor()

    override fun map(type: EntityDependences): DependencesBo {
        return DependencesBo(type.id, type.name, type.description, type.main, type.businessId)
    }

    override fun reverseMap(type: DependencesBo): EntityDependences {
       return return EntityDependences(type.id, type.name, type.description, type.main, type.businessId)
    }
}
