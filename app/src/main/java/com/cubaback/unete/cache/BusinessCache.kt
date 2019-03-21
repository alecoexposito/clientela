package com.cubaback.unete.cache

import com.cubaback.unete.cache.dao.CachedBusinessDao
import com.cubaback.unete.cache.db.JoinUsDatabase
import com.cubaback.unete.cache.model.mapper.CachedBusinessMapper
import com.cubaback.unete.cache.model.mapper.CachedCategoryMapper
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class BusinessCache(val bussinessCachedBusinessDao: CachedBusinessDao,
                    private val cachedBusinessMapper: CachedBusinessMapper,
                    private val preferencesHelper: PreferencesHelper) : IBusinessCache {

    override fun clearBusinesses(): Completable {
        return Completable.defer {
            bussinessCachedBusinessDao.clearBusinesses()
            Completable.complete()
        }
    }

    override fun saveBusinesses(businesses: List<EntityBusiness>): Completable {
        return Completable.defer{
            businesses.forEach {
                bussinessCachedBusinessDao.insertBusiness(cachedBusinessMapper.map(it))
            }
            Completable.complete()
        }
    }

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
       return Flowable.defer {
           Flowable.just(bussinessCachedBusinessDao.getBusinesses())
       }.map {
           it.map { cachedBusinessMapper.reverseMap(it) }
       }
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(bussinessCachedBusinessDao.getBusinesses().isNotEmpty()) }
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
            Single.just(bussinessCachedBusinessDao.getBusinessesById(id = id))
        }.map { cachedBusinessMapper.reverseMap(it) }
    }


}