package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityTransaction
import com.cubaback.unete.domain.model.TransactionBo
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class EntityTransactionMapper() : Mapper<EntityTransaction, TransactionBo>() {
    //constructor()

    override fun map(type: EntityTransaction): TransactionBo {
        val createAt = Date()
        val updatedAt = Date()

        // TODO: Parsear las fechas segun venda desde el API
        return TransactionBo(type.id, type.clientAccountId, type.businessAccountId, createAt, updatedAt)
    }

    override fun reverseMap(type: TransactionBo): EntityTransaction {
        return EntityTransaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
    }
}