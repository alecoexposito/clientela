package com.cubaback.unete.cache.model

data class CachedTransaction(val id : Long?, val clientAccountId : Long?,
                             val businessAccountId : Long?,
                             val createdAt : String?,
                             val updatedAt : String?)