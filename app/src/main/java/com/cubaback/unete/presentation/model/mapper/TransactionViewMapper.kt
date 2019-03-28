package com.cubaback.unete.presentation.model.mapper

import com.cubaback.unete.domain.model.TransactionBo
import com.cubaback.unete.presentation.model.TransactionDataView
import com.cubaback.unete.mapper.Mapper
import java.util.*

open class TransactionViewMapper : Mapper<TransactionBo, TransactionDataView>() {

    override fun map(type: TransactionBo): TransactionDataView {
        return TransactionDataView(type.id, type.clientAccountId, type.businessAccountId, type.createdAt.toString(), type.updatedAt.toString())
    }

    override fun reverseMap(type: TransactionDataView): TransactionBo {
        return TransactionBo(type.id, type.clientAccountId, type.businessAccountId, Date(), Date())
    }
}



