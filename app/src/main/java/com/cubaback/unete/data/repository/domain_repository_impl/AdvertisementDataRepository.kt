package com.cubaback.unete.data.repository.domain_repository_impl

import com.cubaback.unete.data.model.mapper.EntityAdvertisementMapper
import com.cubaback.unete.data.sources.advertisement.AdvertisementDataStoreFactory
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.domain.repository.IAdvertisementRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class AdvertisementDataRepository(private val factory : AdvertisementDataStoreFactory,
                                  private val entityAdvertisementMapper: EntityAdvertisementMapper) : IAdvertisementRepository {

    override fun clearAdvertisement(): Completable {
        return factory.retrieveCacheDataStore().clearAdvertisement()
    }

    override fun saveAdvertisement(entityAdvertisements: AdvertisementBo): Completable {
        return factory.retrieveCacheDataStore().saveAdvertisement(entityAdvertisementMapper.reverseMap(entityAdvertisements))
    }

    override fun getAdvertisements(): Flowable<List<AdvertisementBo>> {
         return factory.retrieveCacheDataStore().isCached()
                 .flatMapPublisher {
                     factory.retrieveDataStore(it).getAdvertisements()
                 }
                 .flatMap {
                     Flowable.just(it.map { entityAdvertisementMapper.map(it) })
                 }

        // save to database....
    }

    override fun isCached(): Single<Boolean> {
        return factory.retrieveCacheDataStore().isCached()
    }

    override fun setLastCached(lastCache: Long) {
        return factory.retrieveCacheDataStore().setLastCached(lastCache)
    }

    override fun getAdvertisementById(id: Long): Single<AdvertisementBo> {
        return factory.retrieveCacheDataStore().getAdvertisementById(id)
                .flatMap {
                    Single.just(entityAdvertisementMapper.map(it))
                }
    }
}