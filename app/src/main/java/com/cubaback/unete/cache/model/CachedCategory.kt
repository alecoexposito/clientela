package com.cubaback.unete.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cubaback.unete.cache.db.constans.DatabaseConstants

@Entity(tableName = DatabaseConstants.CATEGORY_TABLE)
data class CachedCategory(@PrimaryKey val id : Long?, val name : String?,
                          val description : String?,
                          val parentId : Long?)