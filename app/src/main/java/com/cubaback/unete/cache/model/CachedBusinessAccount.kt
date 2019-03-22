package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.BUSINESS_ACCOUNT_TABLE)
data class CachedBusinessAccount(@PrimaryKey
                                 val id : Long?,
                                 val accountNumber : String?,
                                 val defaultPercent : Int?,
                                 val dependenceId : Long?)