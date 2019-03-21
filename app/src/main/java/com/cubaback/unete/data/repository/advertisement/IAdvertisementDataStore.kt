package com.cubaback.unete.data.repository.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface IAdvertisementDataStore {
    fun clearAdvertisement() : Completable
    fun saveAdvertisements(entityAdvertisements: List<EntityAdvertisements>) : Completable
    fun getAdvertisements() : Flowable<List<EntityAdvertisements>>
    fun isCached() : Single<Boolean>
    fun setLastCached(lastCache : Long)
    fun getAdvertisementById(id : Long) : Single<EntityAdvertisements>
    fun hasChanged(date : Date) : Boolean
}