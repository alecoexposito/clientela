package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.cache.model.CachedUser
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class CachedUserMapper() : Mapper<EntityUser, CachedUser> {
    //constructor()

    override fun map(type: EntityUser): CachedUser {

        // todo: cambiar las fechas por las del API
        val createAt = Date()
        val updatedAt = Date()
        return CachedUser(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt.toString(), type.updatedAt.toString())
    }

    override fun reverseMap(type: CachedUser): EntityUser {
        return EntityUser(type.id, type.name, type.lastName, type.email, type.password, type.token, type.createAt.toString(), type.updatedAt.toString())
    }
}