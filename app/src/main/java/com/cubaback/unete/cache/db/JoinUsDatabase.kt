package com.cubaback.unete.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cubaback.unete.cache.model.CachedUser
import com.cubaback.unete.cache.dao.CachedUserDao
import javax.inject.Inject

@Database(entities = arrayOf(CachedUser::class), version = 1)
abstract class JoinUsDatabase: RoomDatabase() {

    abstract fun cachedUserDao(): CachedUserDao

    private var INSTANCE: JoinUsDatabase? = null

    private val sLock = Any()

    fun getInstance(context: Context): JoinUsDatabase {
        if (INSTANCE == null) {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            JoinUsDatabase::class.java, "joinus.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
        return INSTANCE!!
    }

}