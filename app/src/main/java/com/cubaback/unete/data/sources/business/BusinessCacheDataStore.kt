package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.repository.business.IBusinessCache
import com.cubaback.unete.data.repository.business.IBusinessDataStore
import com.cubaback.unete.data.repository.category.ICategoryCache
import com.cubaback.unete.data.repository.category.ICategoryDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

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
}