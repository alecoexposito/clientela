package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.CLIENT_ACCOUNT_TABLE)
data class CachedClientAccount(@PrimaryKey val id: Long?, val accountNumber :  String?,
                               val clientId: Long?)