package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.converter.DateConverter
import java.util.*

@Entity (tableName = DatabaseConstants.USER_TABLE)
data class CachedUser (val id : Long?,
                       val name : String?,
                       val lastName : String?,
                       @PrimaryKey val email : String,
                       val password : String?,
                       val phone : String?,
                       val token : String?,
                       @TypeConverters(DateConverter::class) val birthDate : Date?,
                       @TypeConverters(DateConverter::class) val createAt : Date?,
                       @TypeConverters(DateConverter::class) val updatedAt : Date?)

