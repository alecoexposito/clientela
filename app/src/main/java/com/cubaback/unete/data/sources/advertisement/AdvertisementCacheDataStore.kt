package com.cubaback.unete.data.sources.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import com.cubaback.unete.data.repository.advertisement.IAdvertisementDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

open class AdvertisementCacheDataStore(val advertisementCache : IAdvertisementCache) : IAdvertisementDataStore {
    override fun clearAdvertisement(): Completable {
        return advertisementCache.clearAdvertisement()
    }

    override fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>): Completable {
        return advertisementCache.saveAdvertisements(entityAdvertisements)
    }

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
        return advertisementCache.getAdvertisements()
    }

    override fun isCached(): Single<Boolean> {
        return advertisementCache.isCached()
    }

    override fun setLastCached(lastCache: Long) {
        return advertisementCache.setLastCached(lastCache)
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        return advertisementCache.getAdvertisementById(id)
    }

    override fun hasChanged(date: Date): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}