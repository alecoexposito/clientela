package com.cubaback.unete.cache

import com.cubaback.unete.cache.dao.CachedCategoryDao
import com.cubaback.unete.cache.db.JoinUsDatabase
import com.cubaback.unete.cache.model.CachedCategory
import com.cubaback.unete.cache.model.mapper.CachedCategoryMapper
import com.cubaback.unete.cache.model.mapper.CachedUserMapper
import com.cubaback.unete.data.model.EntityCategory
import com.cubaback.unete.data.repository.category.ICategoryCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class CategoryCache(private val cachedCategoryDao: CachedCategoryDao,
                         private val cachedCategoryMapper: CachedCategoryMapper,
                         private val preferencesHelper: PreferencesHelper) : ICategoryCache{

    override fun clearCategories(): Completable {
        return Completable.defer {
            cachedCategoryDao.clearCategories()
            Completable.complete()
        }
    }

    override fun saveCategories(categories: List<EntityCategory>): Completable {
        return Completable.defer {
            categories.forEach {
                cachedCategoryDao.insertCategories(cachedCategoryMapper.map(it))
            }
            Completable.complete()
        }
    }

    override fun getCategories(): Flowable<List<EntityCategory>> {
        return Flowable.defer {
            Flowable.just(cachedCategoryDao.getCategories())
        }.map {
            it.map { cachedCategoryMapper.reverseMap(it) }
        }
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(cachedCategoryDao.getCategories().isNotEmpty()) }
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheCategories = lastCache
    }

    override fun getLastCacheTime(): Long {
        return preferencesHelper.lastCacheCategories
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<EntityCategory> {
        return Single.defer {
            Single.just(cachedCategoryDao.getCategoryById(id))
        }
        .map { cachedCategoryMapper.reverseMap(it) }
    }

    override fun getCategoriesByParentId(parentId: Long): Flowable<List<EntityCategory>> {
        return Flowable.defer {
            Flowable.just(cachedCategoryDao.getCategoriesByParentId(parentId))
        }.map {
            it.map { cachedCategoryMapper.reverseMap(it) }
        }
    }
}