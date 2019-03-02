package com.cubaback.unete.data.model.mapper

import com.cubaback.unete.data.model.EntityTransaction
import com.cubaback.unete.data.model.Transaction
import com.cubaback.unete.data.model.TransactionBo
import org.buffer.android.boilerplate.data.mapper.Mapper
import java.util.*

open class TransactionBoMapper : Mapper<TransactionBo, Transaction> {
    constructor()

    override fun map(type: TransactionBo): Transaction {
        return Transaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: Transaction): TransactionBo {
        return TransactionBo(type.id, type.clientAccountId, type.businessAccountId, type.createdAt, type.updatedAt)
    }

}