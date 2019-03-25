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
    fun getBusinesses(): List<CachedBusiness>

    // todo: Buscar las relationships con rooms
    @Query("SELECT * FROM ${DatabaseConstants.BUSINESS_TABLE}")
    fun getBusinessesByCategory(): List<CachedBusiness>

    @Query("SELECT * FROM ${DatabaseConstants.BUSINESS_TABLE} WHERE id = :id")
    fun getBusinessesById(id : Long): CachedBusiness

    @Query("DELETE FROM ${DatabaseConstants.BUSINESS_TABLE}")
    fun clearBusinesses()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBusiness(cachedBusiness: CachedBusiness)

}