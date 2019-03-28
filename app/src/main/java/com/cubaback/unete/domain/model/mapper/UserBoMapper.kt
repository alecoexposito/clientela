package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.mapper.Mapper

open class UserBoMapper : Mapper<UserBo, UserDataView>() {
    override fun map(type: UserBo): UserDataView {
        return UserDataView(type.id, type.name, type.lastName, type.email, type.password, type.token, type.phone, type.birthDate, type.isCompleted)
    }

    override fun reverseMap(type: UserDataView): UserBo {
        return UserBo(type.id, type.name, type.lastName, type.email, type.password!!, type.token, type.phone, null, null,  type.birdDate, type.isCompleted)
    }

}