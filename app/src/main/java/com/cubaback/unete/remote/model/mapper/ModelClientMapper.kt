package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.remote.model.ClientModel


/**
 * Transform API Client response to User Entity
 * */
open class ModelClientMapper : Mapper<ClientModel, EntityUser> {

    override fun map(type: ClientModel): EntityUser {
        return EntityUser(type.id, type.user.name, type.user.lastName, type.user.email,
                type.user.password, type.phone, type.birthDate, type.user.token,
                type.createdAt, type.updatedAt )
    }

    override fun reverseMap(type: EntityUser): ClientModel {
        throw UnsupportedOperationException()
    }

}
