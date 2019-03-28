package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.presentation.model.ClientAccountDataView
import com.cubaback.unete.domain.model.ClientAccountBo
import com.cubaback.unete.mapper.Mapper

open class ClientAccountBoMapper : Mapper<ClientAccountBo, ClientAccountDataView>() {


    override fun map(type: ClientAccountBo): ClientAccountDataView {
        return ClientAccountDataView(type.id, type.accountNumber, type.clientId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: ClientAccountDataView): ClientAccountBo {
        return ClientAccountBo(type.id, type.accountNumber, type.clientId, type.createdAt, type.updatedAt)
    }

}