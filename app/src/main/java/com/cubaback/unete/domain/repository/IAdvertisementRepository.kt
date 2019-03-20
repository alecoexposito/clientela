package com.cubaback.unete.domain.repository

import com.cubaback.unete.domain.model.AdvertisementBo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IAdvertisementRepository {

    fun clearAdvertisement() : Completable

    fun saveAdvertisement(entityAdvertisements: AdvertisementBo) : Completable

    fun getAdvertisements() : Flowable<List<AdvertisementBo>>

    fun isCached() : Single<Boolean>

    fun setLastCached(lastCache : Long)

    fun getAdvertisementById(id : Long) : Single<AdvertisementBo>
}