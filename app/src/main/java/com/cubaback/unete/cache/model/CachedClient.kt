package com.cubaback.unete.cache.model

import androidx.room.Entity
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.CLIENT_TABLE)
data class CachedClient (val id : Long?, val phone : String?, val birthDate : String?)