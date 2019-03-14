package com.cubaback.unete.cache

import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class CategoryCache : ICategoryCache{
    override fun clearCategories(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveCategories(Categories: List<EntityCategory>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategories(): Flowable<List<EntityCategory>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(false) }
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<EntityCategory> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}