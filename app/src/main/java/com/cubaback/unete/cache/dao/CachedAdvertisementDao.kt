package com.cubaback.unete.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.CachedAdvertisements

@Dao
interface CachedAdvertisementDao {
    @Query("SELECT * FROM ${DatabaseConstants.ADVERTISEMENT_TABLE}")
    abstract fun getAdvertisements(): List<CachedAdvertisements>

    @Query("SELECT * FROM ${DatabaseConstants.ADVERTISEMENT_TABLE} WHERE id = :id")
    abstract fun getAdvertisementById(id : Long): CachedAdvertisements

    @Query("DELETE FROM ${DatabaseConstants.ADVERTISEMENT_TABLE}")
    abstract fun clearAdvertisement()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAdvertisement(cachedAdvertisement: CachedAdvertisements)
}