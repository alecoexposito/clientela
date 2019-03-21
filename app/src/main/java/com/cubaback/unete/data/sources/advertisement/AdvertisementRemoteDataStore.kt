package com.cubaback.unete.data.sources.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import com.cubaback.unete.data.repository.advertisement.IAdvertisementDataStore
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

open class AdvertisementRemoteDataStore(private val advertisementRemote : IAdvertisementRemote) : IAdvertisementDataStore{
    override fun clearAdvertisement(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getAdvertisements(): Flowable<List<EntityAdvertisements>> {
        return advertisementRemote.getAdvertisements()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun setLastCached(lastCache: Long) {
        throw UnsupportedOperationException()
    }

    override fun getAdvertisementById(id: Long): Single<EntityAdvertisements> {
        return advertisementRemote.getAdvertisementById(id)
    }

    override fun hasChanged(date: Date): Boolean {
        //return advertisementRemote.hasChanged(date)
        throw UnsupportedOperationException()
    }
}