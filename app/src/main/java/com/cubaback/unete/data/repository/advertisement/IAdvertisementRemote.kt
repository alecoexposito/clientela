package com.cubaback.unete.data.repository.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import io.reactivex.Flowable
import io.reactivex.Single

interface IAdvertisementRemote {
    fun getAdvertisements() : Flowable<List<EntityAdvertisements>>
    fun getAdvertisementById(id : Long) : Single<EntityAdvertisements>
}