package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessDataStore
import com.cubaback.unete.data.repository.business.IBusinessRemote
import com.cubaback.unete.data.repository.category.ICategoryDataStore
import com.cubaback.unete.data.repository.category.ICategoryRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

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

    override fun hasChanged(date: Date): Boolean {
        return businessRemote.hasChanged(date)
    }

    override fun getBusinessesByCategory(catID: Long): Flowable<List<EntityBusiness>> {
        throw UnsupportedOperationException()
    }
}