package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.ClientModel
import com.cubaback.unete.data.model.EntityClient
import com.cubaback.unete.mapper.Mapper

open class ModelClientMapper() : Mapper<ClientModel, EntityClient> {
    override fun map(type: ClientModel): EntityClient {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityClient): ClientModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: ClientModel): ClientBo {
//        val date = Date(); // todo: transformar el date segun venga del API
//
//        return ClientBo(type.id, type.phone, date)
//    }
//
//    override fun reverseMap(type: ClientBo): ClientModel {
//        return EntityClient(type.id, type.phone, type.birthDate.toString())
//    }
}
