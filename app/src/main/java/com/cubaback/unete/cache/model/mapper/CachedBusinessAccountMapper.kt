package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.cache.model.CachedBusinessAccount
import com.cubaback.unete.data.model.EntityBusinessAccount
import com.cubaback.unete.mapper.Mapper

open class CachedBusinessAccountMapper : Mapper<EntityBusinessAccount, CachedBusinessAccount> {



    override fun map(type: EntityBusinessAccount): CachedBusinessAccount {
        return CachedBusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }

    override fun reverseMap(type: CachedBusinessAccount): EntityBusinessAccount {
        return EntityBusinessAccount(type.id, type.accountNumber, type.defaultPercent, type.dependenceId)
    }
}