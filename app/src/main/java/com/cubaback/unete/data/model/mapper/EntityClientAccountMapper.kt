package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.domain.model.ClientAccountBo
import com.cubaback.unete.data.model.EntityClientAccount
import com.cubaback.unete.mapper.Mapper

open class EntityClientAccountMapper() : Mapper<EntityClientAccount, ClientAccountBo>() {
   // constructor()

    override fun map(type: EntityClientAccount): ClientAccountBo {
        return ClientAccountBo(type.id, type.accountNumber, type.clientId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: ClientAccountBo): EntityClientAccount {
        return EntityClientAccount(type.id, type.accountNumber, type.clientId, type.createdAt, type.updatedAt)
    }
}