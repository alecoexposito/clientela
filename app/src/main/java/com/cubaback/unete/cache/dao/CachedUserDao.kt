package com.cubaback.unete.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.CachedUser

@Dao
interface  CachedUserDao {

    @Query("SELECT * FROM ${DatabaseConstants.USER_TABLE}")
    fun getUsers(): List<CachedUser>

    @Query("SELECT * FROM ${DatabaseConstants.USER_TABLE} WHERE id = :id")
    fun getUserById(id : Long): CachedUser

    @Query("SELECT * FROM ${DatabaseConstants.USER_TABLE} WHERE email = :email")
    fun getUserByEmail(email : String): CachedUser

    @Query("DELETE FROM ${DatabaseConstants.USER_TABLE}")
    fun clearUsers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(cachedUser: CachedUser)

}