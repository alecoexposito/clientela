package com.cubaback.unete.data.sources.business

import com.cubaback.unete.data.repository.business.IBusinessCache
import com.cubaback.unete.data.repository.business.IBusinessDataStore
import java.util.*

open class BusinessDataStoreFactory (val businessesCache : IBusinessCache,
                                     val businessCacheDataStore : BusinessCacheDataStore,
                                     val businessRemoteDataStore : BusinessRemoteDataStore) {


    open fun retrieveDataStore(isCached: Boolean): IBusinessDataStore {
        if (isCached && !businessRemoteDataStore.hasChanged(Date(businessesCache.getLastCached()))) {
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


