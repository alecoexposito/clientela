package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.remote.model.ClientAccountModel
import com.cubaback.unete.data.model.EntityClientAccount
import com.cubaback.unete.mapper.Mapper

open class ModelClientAccountMapper() : Mapper<ClientAccountModel, EntityClientAccount> {
    override fun map(type: ClientAccountModel): EntityClientAccount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityClientAccount): ClientAccountModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: ClientAccountModel): ClientAccountBo {
//        return ClientAccountBo(type.id, type.accountNumber, type.clientId)
//    }
//
//    override fun reverseMap(type: ClientAccountBo): ClientAccountModel {
//        return EntityClientAccount(type.id, type.accountNumber, type.clientId)
//    }
}