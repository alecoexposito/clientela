package com.cubaback.unete.data.sources.category

import com.cubaback.unete.data.repository.category.ICategoryCache
import com.cubaback.unete.data.repository.category.ICategoryDataStore

open class CategoryDataStoreFactory (val categoryCache : ICategoryCache,
                                     val categoryCacheDataStore : CategoryCacheDataStore,
                                     val categoryRemoteDataStore : CategoryRemoteDataStore) {


    open fun retrieveDataStore(isCached: Boolean): ICategoryDataStore {
        if (isCached) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }


    open fun retrieveCacheDataStore(): ICategoryDataStore {
        return categoryCacheDataStore
    }

    open fun retrieveRemoteDataStore(): ICategoryDataStore {
        return categoryRemoteDataStore
    }
}


