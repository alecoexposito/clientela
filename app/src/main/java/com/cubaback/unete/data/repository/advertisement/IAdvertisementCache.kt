package com.cubaback.unete.data.repository.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IAdvertisementCache {
    fun clearAdvertisement() : Completable
    fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>) : Completable
    fun getAdvertisements() : Flowable<List<EntityAdvertisements>>
    fun isCached() : Single<Boolean>
    fun setLastCached(lastCache : Long)
    fun getLastCached() : Long
    fun getAdvertisementById(id : Long) : Single<EntityAdvertisements>
}