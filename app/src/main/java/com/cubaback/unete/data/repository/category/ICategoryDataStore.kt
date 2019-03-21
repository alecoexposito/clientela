package com.cubaback.unete.data.repository.category

import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.data.model.EntityCategory
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface ICategoryDataStore {
    fun clearCategories(): Completable

    fun saveCategories(categories: List<EntityCategory>): Completable

    fun getCategories(): Flowable<List<EntityCategory>>

    fun isCached(): Single<Boolean>

    fun getCategoryById(id : Long) : Single<EntityCategory>

    fun getCategoriesByParentId(parentId : Long): Flowable<List<EntityCategory>>

    fun hasChanged(date : Date) : Boolean
}