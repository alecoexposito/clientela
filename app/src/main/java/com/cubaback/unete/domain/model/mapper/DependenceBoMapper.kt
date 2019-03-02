package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.Dependences
import com.cubaback.unete.data.model.DependencesBo
import com.cubaback.unete.data.model.EntityDependences
import org.buffer.android.boilerplate.data.mapper.Mapper

open class DependenceBoMapper : Mapper<DependencesBo, Dependences>{
    constructor()

    override fun map(type: DependencesBo): Dependences {
        return Dependences(type.id, type.name, type.description, type.main, type.businessId)
    }

    override fun reverseMap(type: Dependences): DependencesBo {
        return  DependencesBo(type.id, type.name, type.description, type.main, type.businessId)
    }

}
