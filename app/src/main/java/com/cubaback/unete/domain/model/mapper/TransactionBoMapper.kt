package com.cubaback.unete.domain.model.mapper

import com.cubaback.unete.data.model.TransactionView
import com.cubaback.unete.domain.model.TransactionBo
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class TransactionBoMapper : Mapper<TransactionBo, TransactionView> {
    constructor()

    override fun map(type: TransactionBo): TransactionView {
        return TransactionView(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
    }

    override fun reverseMap(type: TransactionView): TransactionBo {
        return TransactionBo(type.id, type.clientAccountId, type.businessAccountId, Date(), Date())
    }

}