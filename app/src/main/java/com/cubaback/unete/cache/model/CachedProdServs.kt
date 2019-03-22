package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.PROD_SERVICES_TABLE)
data class CachedProdServs(@PrimaryKey val id : Long?, val name : String?,
                           val description : String?,
                           val priceMn : Double?,
                           val priceCuc : Double?,
                           val dependenceId : Long?)