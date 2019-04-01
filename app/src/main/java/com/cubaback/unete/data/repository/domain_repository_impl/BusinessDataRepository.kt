package com.cubaback.unete.data.repository.domain_repository_impl

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.model.mapper.EntityBusinessMapper
import com.cubaback.unete.data.sources.business.BusinessDataStoreFactory
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle

open class BusinessDataRepository(private val factory : BusinessDataStoreFactory,
                                  private val businessEntityMapper : EntityBusinessMapper) : IBusinessRepository{

    override fun clearBusinesses(): Completable {
        return factory.retrieveCacheDataStore().clearBusinesses()
    }

    override fun saveBusinesses(businesses: List<BusinessBo>): Completable {
        val businessesEntities = mutableListOf<EntityBusiness>()
        businesses.map { businessesEntities.add(businessEntityMapper.reverseMap(it)) }
        return factory.retrieveCacheDataStore().saveBusinesses(businessesEntities).doOnComplete {
        val lastTime = businesses.sortedBy { it.updatedAt }.last().updatedAt
        lastTime?.let { factory.retrieveCacheDataStore().setLastCacheTime(it.time)  }}
    }

    override fun getBusinesses(): Flowable<List<BusinessBo>> {
        return factory.businessCacheDataStore.isCached()
                .flatMapPublisher {
                    factory.retrieveDataStore(it).getBusinesses()
                }
                .flatMap {
                    Flowable.just(it.map { businessEntityMapper.map(it) })
                }
                .flatMap {
                    saveBusinesses(it).toSingle{it}.toFlowable()
                }
    }

    override fun getBusinessesByCategory(catID: Long): Flowable<List<BusinessBo>> {
        return factory.businessCacheDataStore.getBusinessesByCategory(catID)
                .flatMap {
                    Flowable.just(it.map {it1-> businessEntityMapper.map(it1) })
                }
    }

    override fun getBusinessById(id: Long): Single<BusinessBo> {
        return factory.businessCacheDataStore.getBusinessById(id)
                .flatMap {
                    Single.just(businessEntityMapper.map(it))
                }
    }
}