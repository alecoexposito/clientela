package com.cubaback.unete.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cubaback.unete.cache.dao.CachedAdvertisementDao
import com.cubaback.unete.cache.dao.CachedBusinessDao
import com.cubaback.unete.cache.dao.CachedCategoryDao
import com.cubaback.unete.cache.dao.CachedUserDao
import com.cubaback.unete.cache.model.*

@Database(entities = arrayOf(CachedUser::class, CachedAdvertisements::class,
        CachedBusiness::class, CachedBusinessAccount::class,
        CachedCategory::class, CachedClient::class,
        CachedClientAccount::class, CachedDependences::class,
        CachedProdServs::class, CachedTransaction::class,
        CachedUser::class), version = 1)

 
abstract class JoinUsDatabase: RoomDatabase() {

    abstract fun cachedUserDao(): CachedUserDao

    abstract fun cachedBusinessDao(): CachedBusinessDao

    abstract fun cachedCategoryDao(): CachedCategoryDao

    abstract fun cachedAdvertisementDao(): CachedAdvertisementDao

}