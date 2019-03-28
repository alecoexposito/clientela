package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.presentation.model.ClientDataView

open class ClientBoMapper(private val userBoMapper: UserBoMapper,
                          private val clientAccountBoMapper: ClientAccountBoMapper) : Mapper<ClientBo, ClientDataView>() {


    override fun map(type: ClientBo): ClientDataView {
        return ClientDataView(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { userBoMapper.map(it) },
                type.account?.let { clientAccountBoMapper.map(it) })
    }

    override fun reverseMap(type: ClientDataView): ClientBo {
        return ClientBo(type.id,  type.phone, type.birthDate, type.createdAt, type.updatedAt,
                type.user?.let { userBoMapper.reverseMap(it) },
                type.account?.let { clientAccountBoMapper.reverseMap(it) })
    }

}
