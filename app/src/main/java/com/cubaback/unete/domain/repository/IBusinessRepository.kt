package com.cubaback.unete.domain.repository

import com.cubaback.unete.domain.model.BusinessBo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IBusinessRepository{

    fun clearBusinesses(): Completable

    fun saveBusinesses(businesses: List<BusinessBo>): Completable

    fun getBusinesses(): Flowable<List<BusinessBo>>


    fun getBusinessById(id : Long): Single<BusinessBo>
}