package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.BUSINESS_TABLE)
class CachedBusiness(@PrimaryKey val id : Long?, val name: String?, val description: String?)