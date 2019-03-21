package com.cubaback.unete.data.sources.advertisement

import com.cubaback.unete.data.repository.advertisement.IAdvertisementCache
import com.cubaback.unete.data.repository.advertisement.IAdvertisementDataStore
import com.cubaback.unete.data.repository.advertisement.IAdvertisementRemote

open class AdvertisementDataStoreFactory(private val advertisementCache: IAdvertisementCache,
                                         private val advertisementCacheDataStore: AdvertisementCacheDataStore,
                                         private val advertisementRemoteDataStore: AdvertisementRemoteDataStore) {

    open fun retrieveDataStore(isCached: Boolean) : IAdvertisementDataStore {
        if (isCached /*&& !advertisementRemote.hasChanged(Date(advertisementCache.getLastCached()))*/) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }


    open fun retrieveCacheDataStore(): IAdvertisementDataStore {
        return advertisementCacheDataStore
    }

    open fun retrieveRemoteDataStore(): IAdvertisementDataStore {
        return advertisementRemoteDataStore
    }
}