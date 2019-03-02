package com.cubaback.unete.data.repository.impl

import com.cubaback.unete.data.model.Business
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.model.mapper.BusinessBoMapper
import com.cubaback.unete.data.sources.business.BusinessDataStoreFactory
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class BusinessDataRepository(private val factory : BusinessDataStoreFactory,
                                  private val businessEntityMapper : BusinessBoMapper) : IBusinessRepository{

    override fun clearBusinesses(): Completable {
        return factory.retrieveCacheDataStore().clearBusinesses()
    }

    override fun saveBusinesses(businesses: List<Business>): Completable {
        val businessesEntities = mutableListOf<EntityBusiness>()
        businesses.map { businessesEntities.add(businessEntityMapper.reverseMap(it)) }
        return factory.retrieveCacheDataStore().saveBusinesses(businessesEntities)
    }

    override fun getBusinesses(): Flowable<List<Business>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBusinessById(id: Long): Single<Business> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}