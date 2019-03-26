package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityClientAccount
import com.cubaback.unete.mapper.Mapper
import com.cubaback.unete.remote.model.ClientAccountModel

open class ModelClientAccountMapper : Mapper<ClientAccountModel, EntityClientAccount>() {
    override fun map(type: ClientAccountModel): EntityClientAccount {
        return  EntityClientAccount(type.id,
                                    type.accountNumber,
                                    type.clientId,
                                    type.createdAt,
                                    type.updatedAt)
    }

    override fun reverseMap(type: EntityClientAccount): ClientAccountModel {
        return  ClientAccountModel(type.id,
                type.accountNumber,
                type.clientId,
                type.createdAt,
                type.updatedAt)
    }


}