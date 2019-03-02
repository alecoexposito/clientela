package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.ClientAccountBo
import com.cubaback.unete.data.model.EntityClientAccount
import org.buffer.android.boilerplate.data.mapper.Mapper

open class EntityClientAccountMapper : Mapper<EntityClientAccount, ClientAccountBo>{
    constructor()

    override fun map(type: EntityClientAccount): ClientAccountBo {
        return ClientAccountBo(type.id, type.accountNumber, type.clientId)
    }

    override fun reverseMap(type: ClientAccountBo): EntityClientAccount {
        return EntityClientAccount(type.id, type.accountNumber, type.clientId)
    }
}