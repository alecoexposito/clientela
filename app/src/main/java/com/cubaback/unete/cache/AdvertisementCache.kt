package com.cubaback.unete.cache

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class AdvertisementCache : IAdvertisementCache {
    override fun clearAdvertisement(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAdvertisement(entityAdvertisements: EntityAdvertisements): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        return Single.defer { Single.just(false) }
    }

    override fun setLastCached(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}