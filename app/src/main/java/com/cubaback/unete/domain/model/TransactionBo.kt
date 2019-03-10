package com.cubaback.unete.domain.model

import java.util.*

data class TransactionBo(val id : Long?, val clientAccountId : Long?,
                         val businessAccountId : Long?,
                         val createdAt : Date?,
                         val updatedAt : Date?)