package com.cubaback.unete.data.sources.category

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryDataStore
import com.cubaback.unete.data.repository.category.ICategoryRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

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

    override fun getCategoriesByParentId(parentId: Long): Flowable<List<EntityCategory>> {
        throw UnsupportedOperationException()
    }

    override fun hasChanged(date: Date): Boolean {
        return categoryRemote.hasChanged(date)
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastCacheTime(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastCached(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}