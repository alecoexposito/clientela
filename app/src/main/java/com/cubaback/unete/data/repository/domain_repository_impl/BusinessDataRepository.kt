package com.cubaback.unete.data.repository.domain_repository_impl

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.model.mapper.EntityBusinessMapper
import com.cubaback.unete.data.sources.business.BusinessDataStoreFactory
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

open class BusinessDataRepository(private val factory : BusinessDataStoreFactory,
                                  private val businessEntityMapper : EntityBusinessMapper) : IBusinessRepository{

    override fun clearBusinesses(): Completable {
        return factory.retrieveCacheDataStore().clearBusinesses()
    }

    override fun saveBusinesses(businesses: List<BusinessBo>): Completable {
        val businessesEntities = mutableListOf<EntityBusiness>()
        businesses.map { businessesEntities.add(businessEntityMapper.reverseMap(it)) }
        return factory.retrieveCacheDataStore().saveBusinesses(businessesEntities)
    }

    override fun getBusinesses(): Flowable<List<BusinessBo>> {
        return factory.businessCacheDataStore.isCached()
                .flatMapPublisher {
                    factory.retrieveDataStore(it).getBusinesses()
                }
                .flatMap {
                    Flowable.just(it.map { businessEntityMapper.map(it) })
                }
//                .flatMap {
//                    saveBusinesses(it).toSingle{it}.toFlowable()
//                }
    }

    override fun getBusinessById(id: Long): Single<BusinessBo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}