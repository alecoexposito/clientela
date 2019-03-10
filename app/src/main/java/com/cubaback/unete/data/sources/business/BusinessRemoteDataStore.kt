package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessDataStore
import com.cubaback.unete.data.repository.business.IBusinessRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class BusinessRemoteDataStore(private val businessRemote : IBusinessRemote) : IBusinessDataStore {
    override fun clearBusinesses(): Completable {
        throw UnsupportedOperationException() as Throwable
    }

    override fun saveBusinesses(businesses: List<EntityBusiness>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
        return businessRemote.getBusinesses()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        return businessRemote.getBusinessById(id)
    }
}