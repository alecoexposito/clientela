package com.cubaback.unete.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cubaback.unete.cache.db.constans.DatabaseConstants
import com.cubaback.unete.cache.model.CachedCategory
import io.reactivex.Single

@Dao
interface CachedCategoryDao {

    @Query("SELECT * FROM ${DatabaseConstants.CATEGORY_TABLE}")
    fun getCategories(): List<CachedCategory>

    @Query("SELECT * FROM ${DatabaseConstants.CATEGORY_TABLE} WHERE id = :id")
    fun getCategoryById(id : Long): CachedCategory

    @Query("SELECT * FROM ${DatabaseConstants.CATEGORY_TABLE} WHERE parentId = :parentId")
    fun getCategoriesByParentId(parentId : Long): List<CachedCategory>


    @Query("DELETE FROM ${DatabaseConstants.CATEGORY_TABLE}")
    fun clearCategories()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(cachedCategory: CachedCategory)

}