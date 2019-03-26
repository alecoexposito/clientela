package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityTransaction
import com.cubaback.unete.remote.model.TransactionModel
import com.cubaback.unete.mapper.Mapper

open class ModelTransactionMapper : Mapper<TransactionModel, EntityTransaction>() {
    override fun map(type: TransactionModel): EntityTransaction {
       return EntityTransaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt, type.updatedAt)
    }

    override fun reverseMap(type: EntityTransaction): TransactionModel {
        return TransactionModel(type.id, type.clientAccountId, type.businessAccountId, type.createdAt, type.updatedAt)
    }
}