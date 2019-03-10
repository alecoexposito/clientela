package com.cubaback.unete.data.repository.business

import com.cubaback.unete.data.model.EntityBusiness
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IBusinessDataStore {
    fun clearBusinesses(): Completable

    fun saveBusinesses(businesses: List<EntityBusiness>): Completable

    fun getBusinesses(): Flowable<List<EntityBusiness>>

    fun isCached(): Single<Boolean>

    fun getBusinessById(id : Long) : Single<EntityBusiness>
}