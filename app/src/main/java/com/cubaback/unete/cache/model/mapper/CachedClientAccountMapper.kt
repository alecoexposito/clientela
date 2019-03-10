package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedClientAccount
import com.cubaback.unete.data.model.EntityClientAccount
import com.cubaback.unete.mapper.Mapper

open class CachedClientAccountMapper() : Mapper<EntityClientAccount, CachedClientAccount> {
   // constructor()

    override fun map(type: EntityClientAccount): CachedClientAccount {
        return CachedClientAccount(type.id, type.accountNumber, type.clientId)
    }

    override fun reverseMap(type: CachedClientAccount): EntityClientAccount {
        return EntityClientAccount(type.id, type.accountNumber, type.clientId)
    }
}