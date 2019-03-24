package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.converter.DateConverter
import java.util.*

@Entity(tableName = DatabaseConstants.CLIENT_TABLE)
data class CachedClient (@PrimaryKey val id : Long?,
                         val phone : String?,
                         @TypeConverters(DateConverter::class) val birthDate : Date?,
                         @TypeConverters(DateConverter::class) val createdAt : Date?,
                         @TypeConverters(DateConverter::class) val updatedAt : Date?)