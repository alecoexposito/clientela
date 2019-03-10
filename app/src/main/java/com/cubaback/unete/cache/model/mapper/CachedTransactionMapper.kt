package com.cubaback.unete.cache.model.mapper

import com.cubaback.unete.data.model.EntityTransaction
import com.cubaback.unete.cache.model.CachedTransaction
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class CachedTransactionMapper() : Mapper<EntityTransaction, CachedTransaction> {
    //constructor()

    override fun map(type: EntityTransaction): CachedTransaction {
        val createAt = Date()
        val updatedAt = Date()

        // TODO: Parsear las fechas segun venda desde el API
        return CachedTransaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
    }

    override fun reverseMap(type: CachedTransaction): EntityTransaction {
        return EntityTransaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
    }
}