package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.UserConstants

@Entity (tableName = UserConstants.TABLE_NAME)
data class CachedUser (@PrimaryKey val id : Long?,
                       val name : String?,
                       val lastName : String?,
                       val email : String?,
                       val password : String?,
                       val token : String?,
                       val createAt : String?,
                       val updatedAt : String?)

