package com.cubaback.unete.cache.model

import androidx.room.Entity
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import java.util.*

@Entity(tableName = DatabaseConstants.ADVERTISEMENT_TABLE)
data class CachedAdvertisements(val id : Long?, val title : String?, val description : String?, val image : String?,
                                val createdAt : Date?, val updatedAt : Date?)