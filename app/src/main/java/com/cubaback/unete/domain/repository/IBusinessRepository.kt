package com.cubaback.unete.domain.repository

import com.cubaback.unete.data.model.Business
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IBusinessRepository{

    fun clearBusinesses(): Completable

    fun saveBusinesses(businesses: List<Business>): Completable

    fun getBusinesses(): Flowable<List<Business>>


    fun getBusinessById(id : Long): Single<Business>
}