package com.cubaback.unete.cache

import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.cache.model.mapper.CachedCategoryMapper
import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryCache
import com.vicpin.krealmextensions.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class CategoryCache(private val cachedCategoryMapper: CachedCategoryMapper,
                         private val preferencesHelper: PreferencesHelper) : ICategoryCache{

    override fun clearCategories(): Completable {
        return Completable.defer {
            CachedCategory().deleteAll()
            Completable.complete()
        }
    }

    override fun saveCategories(categories: List<EntityCategory>): Completable {
        return Completable.defer {
            categories.forEach {
               cachedCategoryMapper.map(it).createOrUpdate()
            }
            Completable.complete()
        }
    }

    override fun getCategories(): Flowable<List<EntityCategory>> {
        return Flowable.defer {
             Flowable.just(CachedCategory().queryAll())
                     .map {
                         cachedCategoryMapper.reverseMap(it)
                     }
        }


    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(CachedCategory().queryAll().isNotEmpty()) }
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheCategories = lastCache
    }

    override fun getLastCacheTime(): Long {
        return preferencesHelper.lastCacheCategories
    }

    override fun getLastCached(): Long {
        return preferencesHelper.lastCacheCategories
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<EntityCategory> {
        return Single.defer {
            Single.just(CachedCategory().queryFirst {
                this.equalTo("id", id)
            })
        }
        .map { cachedCategoryMapper.reverseMap(it) }
    }

    override fun getCategoriesByParentId(parentId: Long): Flowable<List<EntityCategory>> {
        return Flowable.defer {
           Flowable.just(CachedCategory().query {
                this.equalTo("parentId", parentId)
            })
        } .map { cachedCategoryMapper.reverseMap(it) }
    }
}