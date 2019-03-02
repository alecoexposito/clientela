package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.model.UserBo
import org.buffer.android.boilerplate.data.mapper.Mapper
import java.util.*

open class EntityUserMapper : Mapper<EntityUser, UserBo>{
    constructor()

    override fun map(type: EntityUser): UserBo {

        // todo: cambiar las fechas por las del API
        val createAt = Date()
        val updatedAt = Date()
        return UserBo(type.id, type.name, type.lastName, type.email, type.password, type.token, createAt, updatedAt)
    }

    override fun reverseMap(type: UserBo): EntityUser {
        return EntityUser(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt.toString(), type.updatedAt.toString())
    }
}