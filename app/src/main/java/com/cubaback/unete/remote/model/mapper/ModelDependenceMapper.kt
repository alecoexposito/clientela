package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.DependencesModel
import com.cubaback.unete.data.model.EntityDependences
import com.cubaback.unete.mapper.Mapper

open class ModelDependenceMapper() : Mapper<DependencesModel, EntityDependences> {
    override fun map(type: DependencesModel): EntityDependences {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityDependences): DependencesModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: DependencesModel): DependencesBo {
//        return DependencesBo(type.id, type.name, type.description, type.main, type.businessId)
//    }
//
//    override fun reverseMap(type: DependencesBo): DependencesModel {
//       return  EntityDependences(type.id, type.name, type.description, type.main, type.businessId)
//    }
}
