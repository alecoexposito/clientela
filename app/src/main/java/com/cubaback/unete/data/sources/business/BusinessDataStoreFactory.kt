package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.repository.IBusinessCache
import com.cubaback.unete.data.repository.IBusinessDataStore

open class BusinessDataStoreFactory (private val businessesCache : IBusinessCache,
                                     private val businessCacheDataStore : BusinessCacheDataStore,
                                     private val businessRemoteDataStore : BusinessRemoteDataStore) {


    open fun retrieveDataStore(isCached: Boolean): IBusinessDataStore {
        if (isCached && !businessesCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }


    open fun retrieveCacheDataStore(): IBusinessDataStore {
        return businessCacheDataStore
    }

    open fun retrieveRemoteDataStore(): IBusinessDataStore {
        return businessRemoteDataStore
    }
}


