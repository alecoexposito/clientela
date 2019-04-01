package com.cubaback.unete.data.repository.business

import com.cubaback.unete.data.model.EntityBusiness
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface IBusinessDataStore {
    fun clearBusinesses(): Completable

    fun saveBusinesses(businesses: List<EntityBusiness>): Completable

    fun getBusinesses(): Flowable<List<EntityBusiness>>

    fun isCached(): Single<Boolean>

    fun getBusinessById(id : Long) : Single<EntityBusiness>

    fun hasChanged(date : Date) : Boolean

    fun getBusinessesByCategory(catID : Long) : Flowable<List<EntityBusiness>>

    /**
     * Cambia la fecha de la ultima cache
     * */
    fun setLastCacheTime(lastCache : Long)


    fun getLastCacheTime() : Long

    fun getLastCached() : Long



}