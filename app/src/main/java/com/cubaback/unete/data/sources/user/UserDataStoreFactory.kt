package com.cubaback.unete.data.sources.user

import com.cubaback.unete.data.repository.user.IUserCache
import com.cubaback.unete.data.repository.user.IUserDataStore

open class UserDataStoreFactory (val userCache: IUserCache,
                                 val userCacheDataStore: UserCacheDataStore,
                                 val userRemoteDataStore: UserRemoteDataStore) {


    open fun retrieveDataStore(isLoged: Boolean): IUserDataStore {
        if (isLoged && userCache.isLoged()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }


    open fun retrieveCacheDataStore(): IUserDataStore {
        return userCacheDataStore
    }

    open fun retrieveRemoteDataStore(): IUserDataStore {
        return userRemoteDataStore
    }
}


