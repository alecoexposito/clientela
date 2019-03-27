package com.cubaback.unete.cache

import com.cubaback.unete.cache.model.CachedBusiness
import com.cubaback.unete.cache.model.mapper.CachedBusinessMapper
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessCache
import com.vicpin.krealmextensions.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class BusinessCache(
                    private val cachedBusinessMapper: CachedBusinessMapper,
                    private val preferencesHelper: PreferencesHelper) : IBusinessCache {

    override fun clearBusinesses(): Completable {
        return Completable.defer {
             CachedBusiness().deleteAll()
            Completable.complete()
        }
    }

    override fun saveBusinesses(businesses: List<EntityBusiness>): Completable {
        return Completable.defer{
            businesses.forEach {
                cachedBusinessMapper.map(it).createOrUpdate()
            }
            Completable.complete()
        }
    }

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
       return Flowable.defer {
            Flowable.just(CachedBusiness().queryAll())
            .map {
                cachedBusinessMapper.reverseMap(it)
            }
       }
    }

    override fun getBusinessesByCategory(catID: Long): Flowable<List<EntityBusiness>> {
        return Flowable.defer {
            Flowable.just(CachedBusiness().query {
                             this.equalTo("categories.id", catID)})
                    .map {  cachedBusinessMapper.reverseMap(it) }
        }
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(CachedBusiness().queryAll().isNotEmpty())}
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheBusinesses = lastCache
    }

    override fun getLastCacheTime(): Long {
        return preferencesHelper.lastCacheBusinesses
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        return Single.defer {
            Single.just(CachedBusiness().queryFirst{
                this.equalTo("id", id)
                })
            }.map { cachedBusinessMapper.reverseMap(it) }
    }




}