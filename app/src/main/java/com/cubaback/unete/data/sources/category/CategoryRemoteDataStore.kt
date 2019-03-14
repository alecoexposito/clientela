package com.cubaback.unete.data.sources.category

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryDataStore
import com.cubaback.unete.data.repository.category.ICategoryRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class CategoryRemoteDataStore(private val categoryRemote : ICategoryRemote) : ICategoryDataStore {
    override fun clearCategories(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveCategories(categories: List<EntityCategory>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getCategories(): Flowable<List<EntityCategory>> {
        return categoryRemote.getCategories()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun getCategoryById(id: Long): Single<EntityCategory> {
       return categoryRemote.getCategoryById(id)
    }
}