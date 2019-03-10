package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.ClientAccountView
import com.cubaback.unete.domain.model.ClientAccountBo
import com.cubaback.unete.mapper.Mapper

open class ClientAccountBoMapper : Mapper<ClientAccountBo, ClientAccountView> {
    constructor()

    override fun map(type: ClientAccountBo): ClientAccountView {
        return ClientAccountView(type.id, type.accountNumber, type.clientId)
    }

    override fun reverseMap(type: ClientAccountView): ClientAccountBo {
        return ClientAccountBo(type.id, type.accountNumber, type.clientId)
    }

}