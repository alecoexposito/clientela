package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.ClientAccount
import com.cubaback.unete.data.model.ClientAccountBo
import com.cubaback.unete.data.model.EntityClientAccount
import org.buffer.android.boilerplate.data.mapper.Mapper

open class ClientAccountBoMapper : Mapper<ClientAccountBo, ClientAccount>{
    constructor()

    override fun map(type: ClientAccountBo): ClientAccount {
        return ClientAccount(type.id, type.accountNumber, type.clientId)
    }

    override fun reverseMap(type: ClientAccount): ClientAccountBo {
        return ClientAccountBo(type.id, type.accountNumber, type.clientId)
    }

}