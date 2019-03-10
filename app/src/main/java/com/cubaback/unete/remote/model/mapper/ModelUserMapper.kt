package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.remote.model.UserModel
import com.cubaback.unete.mapper.Mapper

open class ModelUserMapper() : Mapper<UserModel, EntityUser> {
    override fun map(type: UserModel): EntityUser {
        return EntityUser(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt, type.updatedAt)
    }

    override fun reverseMap(type: EntityUser): UserModel {
        return UserModel(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt, type.updatedAt)
    }

}