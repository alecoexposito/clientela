package com.cubaback.unete.data.sources.category

import com.cubaback.unete.data.repository.category.ICategoryCache
import com.cubaback.unete.data.repository.category.ICategoryDataStore
import java.util.*

open class CategoryDataStoreFactory (val categoryCache : ICategoryCache,
                                     val categoryCacheDataStore : CategoryCacheDataStore,
                                     val categoryRemoteDataStore : CategoryRemoteDataStore) {


    open fun retrieveDataStore(isCached: Boolean): ICategoryDataStore {
        if (isCached && !categoryRemoteDataStore.hasChanged(Date(categoryCache.getLastCached()))) {
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


