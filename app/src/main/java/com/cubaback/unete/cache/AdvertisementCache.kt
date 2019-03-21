package com.cubaback.unete.cache

import com.cubaback.unete.cache.dao.CachedAdvertisementDao
import com.cubaback.unete.cache.db.JoinUsDatabase
import com.cubaback.unete.cache.model.mapper.CachedAdvertisementMapper
import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class AdvertisementCache(val cachedAdvertisementDao: CachedAdvertisementDao,
                         private val cachedAdvertisementMapper: CachedAdvertisementMapper,
                         private val preferencesHelper: PreferencesHelper) : IAdvertisementCache {


    override fun clearAdvertisement(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>): Completable {
        return Completable.defer{
            entityAdvertisements.forEach {
                cachedAdvertisementDao.insertAdvertisement(cachedAdvertisementMapper.map(it))
            }
            Completable.complete()
        }

    }

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
        return Flowable.defer {
            Flowable.just(cachedAdvertisementDao.getAdvertisements())
        }.map {
            it.map { cachedAdvertisementMapper.reverseMap(it) }
        }
    }


    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(cachedAdvertisementDao.getAdvertisements().isNotEmpty()) }
    }

    override fun setLastCached(lastCache: Long) {
        preferencesHelper.lastCacheAdvertisement = lastCache
    }

    override fun getLastCached(): Long {
        return preferencesHelper.lastCacheAdvertisement
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}