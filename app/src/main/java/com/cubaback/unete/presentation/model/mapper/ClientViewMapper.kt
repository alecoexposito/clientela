package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.presentation.model.ClientView
import com.cubaback.unete.mapper.Mapper

class ClientViewMapper(private val userViewMapper: UserViewMapper) : Mapper<ClientBo, ClientView> {

    override fun map(type: ClientBo): ClientView {
        return ClientView(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt, type.user?.let { userViewMapper.map(it)   })
    }

    override fun reverseMap(type: ClientView): ClientBo {
        return ClientBo(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt, type.user?.let { userViewMapper.reverseMap(it) } )
    }
}