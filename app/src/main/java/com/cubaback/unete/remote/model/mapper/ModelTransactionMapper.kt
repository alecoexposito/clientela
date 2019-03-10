package com.cubaback.unete.remote.model.mapper

import com.cubaback.unete.data.model.EntityTransaction
import com.cubaback.unete.remote.model.TransactionModel
import com.cubaback.unete.mapper.Mapper

open class ModelTransactionMapper() : Mapper<TransactionModel, EntityTransaction> {
    override fun map(type: TransactionModel): EntityTransaction {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reverseMap(type: EntityTransaction): TransactionModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //    override fun map(type: TransactionModel): TransactionBo {
//        val createAt = Date()
//        val updatedAt = Date()
//
//        // TODO: Parsear las fechas segun venda desde el API
//        return TransactionBo(type.id, type.clientAccountId, type.businessAccountId, createAt, updatedAt)
//    }
//
//    override fun reverseMap(type: TransactionBo): TransactionModel {
//        return EntityTransaction(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
//    }
}