package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.presentation.model.ClientDataView
import com.cubaback.unete.mapper.Mapper

class ClientViewMapper(private val userViewMapper: UserViewMapper,
                       private val clientAccountViewMapper: ClientAccountViewMapper) : Mapper<ClientBo, ClientDataView>() {

    override fun map(type: ClientBo): ClientDataView {
        return ClientDataView(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { userViewMapper.map(it)},
                type.account?.let { clientAccountViewMapper.map(it) })
    }

    override fun reverseMap(type: ClientDataView): ClientBo {
        return ClientBo(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { userViewMapper.reverseMap(it) },
                type.account?.let { clientAccountViewMapper.reverseMap(it) })
    }
}