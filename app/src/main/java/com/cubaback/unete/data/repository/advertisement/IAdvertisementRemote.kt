package com.cubaback.unete.data.repository.advertisement

import com.cubaback.unete.data.model.EntityAdvertisements
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface IAdvertisementRemote {
    fun getAdvertisements() : Flowable<List<EntityAdvertisements>>
    fun getAdvertisementById(id : Long) : Single<EntityAdvertisements>
    fun hasChanged(date : Date) : Boolean
}