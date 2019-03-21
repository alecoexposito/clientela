package com.cubaback.unete.cache.model

import androidx.room.Entity
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.PROD_SERVICES_TABLE)
data class CachedProdServs(val id : Long?, val name : String?,
                           val description : String?,
                           val priceMn : Double?,
                           val priceCuc : Double?,
                           val dependenceId : Long?)