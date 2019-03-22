package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.TRANSACTION_TABLE)
data class CachedTransaction(@PrimaryKey val id : Long?, val clientAccountId : Long?,
                             val businessAccountId : Long?,
                             val createdAt : String?,
                             val updatedAt : String?)