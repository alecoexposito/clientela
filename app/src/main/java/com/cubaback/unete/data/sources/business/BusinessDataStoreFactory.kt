package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.repository.business.IBusinessCache
import com.cubaback.unete.data.repository.business.IBusinessDataStore

open class BusinessDataStoreFactory (val businessesCache : IBusinessCache,
                                     val businessCacheDataStore : BusinessCacheDataStore,
                                     val businessRemoteDataStore : BusinessRemoteDataStore) {


    open fun retrieveDataStore(isCached: Boolean): IBusinessDataStore {
        if (isCached) {
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


