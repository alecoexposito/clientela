package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.cache.model.CachedUser
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.utils.Utils
import java.util.*

open class CachedUserMapper : Mapper<EntityUser, CachedUser> {
    override fun map(type: EntityUser): CachedUser {
        return CachedUser(type.id, type.name, type.lastName, type.email!!, type.password, type.phone, type.token, type.birthDate,  type.createAt, type.updatedAt)
    }

    override fun reverseMap(type: CachedUser): EntityUser {
        return EntityUser(type.id, type.name, type.lastName, type.email, type.password, type.phone, type.birthDate, type.token,  type.createAt, type.updatedAt)
    }
}