package com.cubaback.unete.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.CachedBusiness
import com.cubaback.unete.cache.model.CachedCategory

@Dao
interface CachedBusinessDao {

    @Query("SELECT * FROM ${DatabaseConstants.BUSINESS_TABLE}")
    abstract fun getBusinesses(): List<CachedBusiness>

    @Query("SELECT * FROM ${DatabaseConstants.BUSINESS_TABLE} WHERE id = :id")
    abstract fun getBusinessesById(id : Long): CachedBusiness

    @Query("DELETE FROM ${DatabaseConstants.BUSINESS_TABLE}")
    abstract fun clearBusinesses()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBusiness(cachedBusiness: CachedBusiness)

}