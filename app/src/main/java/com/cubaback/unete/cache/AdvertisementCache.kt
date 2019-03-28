package com.cubaback.unete.cache

import com.cubaback.unete.cache.model.CachedAdvertisements
import com.cubaback.unete.cache.model.mapper.CachedAdvertisementMapper
import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import com.vicpin.krealmextensions.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class AdvertisementCache(private val cachedAdvertisementMapper: CachedAdvertisementMapper,
                         private val preferencesHelper: PreferencesHelper) : IAdvertisementCache {


    override fun clearAdvertisement(): Completable {
       throw UnsupportedOperationException()
    }

    override fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>): Completable {
        return Completable.defer{
            entityAdvertisements.forEach {
                cachedAdvertisementMapper.map(it).createOrUpdate()
            }
            Completable.complete()
        }

    }

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
        return Flowable.defer {
            Flowable.just(CachedAdvertisements().queryAll())
        }.map { cachedAdvertisementMapper.reverseMap(it) }
    }


    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(CachedAdvertisements().queryAll().isNotEmpty()) }
    }

    override fun setLastCached(lastCache: Long) {
        preferencesHelper.lastCacheAdvertisement = lastCache
    }

    override fun getLastCached(): Long {
        return preferencesHelper.lastCacheAdvertisement
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        return Single.defer { Single.just(
                CachedAdvertisements()
                .queryFirst {
                                 this.equalTo("id", id)
                             }
        )
        }.map {
            cachedAdvertisementMapper.reverseMap(it)
        }
    }
}