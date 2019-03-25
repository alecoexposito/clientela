package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessCache
import com.cubaback.unete.data.repository.business.IBusinessDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

open class BusinessCacheDataStore(private val businessCache : IBusinessCache) : IBusinessDataStore {

    override fun clearBusinesses(): Completable {
        return businessCache.clearBusinesses()
    }

    override fun saveBusinesses(businesses: List<EntityBusiness>): Completable {
        return businessCache.saveBusinesses(businesses)
    }

    override fun getBusinesses(): Flowable<List<EntityBusiness>> {
       return businessCache.getBusinesses()
    }

    override fun isCached(): Single<Boolean> {
        return businessCache.isCached()
    }

    override fun getBusinessById(id: Long): Single<EntityBusiness> {
        return businessCache.getBusinessById(id)
    }

    override fun getBusinessesByCategory(catID: Long): Flowable<List<EntityBusiness>> {
        return businessCache.getBusinessesByCategory(catID)
    }

    override fun hasChanged(date: Date): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}