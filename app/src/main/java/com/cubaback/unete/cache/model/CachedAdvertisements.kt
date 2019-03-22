package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.converter.DateConverter
import java.util.*

@Entity(tableName = DatabaseConstants.ADVERTISEMENT_TABLE)
data class CachedAdvertisements(@PrimaryKey val id : Long?, val title : String?, val description : String?, val image : String?,
                                @TypeConverters(DateConverter::class) val createdAt : Date?, @TypeConverters(DateConverter::class) val updatedAt : Date?)