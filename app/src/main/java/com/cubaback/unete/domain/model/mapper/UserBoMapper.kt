package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.User
import com.cubaback.unete.data.model.UserBo
import org.buffer.android.boilerplate.data.mapper.Mapper

open class UserBoMapper : Mapper<UserBo, User>{
    constructor()

    override fun map(type: UserBo): User {
        return User(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt, type.updatedAt)
    }

    override fun reverseMap(type: User): UserBo {
        return UserBo(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt, type.updatedAt)
    }

}