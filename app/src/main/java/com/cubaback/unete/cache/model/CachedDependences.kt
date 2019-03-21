package com.cubaback.unete.cache.model

import androidx.room.Entity
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.DEPENDENCE_TABLE)
data class CachedDependences(val id : Long?, val name : String?,
                             val description : String?, val main : Boolean? = false,
                             val businessId : Long?)