package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.utils.Utils

open class EntityUserMapper  : Mapper<EntityUser, UserBo> {
    override fun map(type: EntityUser): UserBo {
        return UserBo(type.id, type.name, type.lastName, type.email, type.password, type.token, type.phone,
                type.createAt, type.updatedAt, type.birthDate,
                Utils.compareWithDefaultDate(type.birthDate) && type.phone != Utils.DEFAULT_PHONE_NUMBER)
    }

    override fun reverseMap(type: UserBo): EntityUser {
        return EntityUser(type.id, type.name, type.lastName, type.email, type.password, type.phone, type.birthDate, type.token,
                type.createAt, type.updatedAt)
    }
}