package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.ClientView
import com.cubaback.unete.domain.model.ClientBo
import com.cubaback.unete.mapper.Mapper

open class ClientBoMapper : Mapper<ClientBo, ClientView> {
    constructor()

    override fun map(type: ClientBo): ClientView {
        return ClientView(type.id, type.phone, type.birthDate)
    }

    override fun reverseMap(type: ClientView): ClientBo {
        return ClientBo(type.id, type.phone, type.birthDate)
    }

}
