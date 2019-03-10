package com.cubaback.unete.data.sources.user

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.repository.user.IUserCache
import com.cubaback.unete.data.repository.user.IUserDataStore
import io.reactivex.Completable
import io.reactivex.Single

open class UserCacheDataStore(val userCache : IUserCache) : IUserDataStore {

    override fun register(user: EntityUser): Single<EntityUser> {
        throw UnsupportedOperationException()
    }

    override fun login(user: EntityUser): Single<EntityUser> {
        throw UnsupportedOperationException()
    }

    override fun saveUser(user: EntityUser): Completable {
       return userCache.saveUser(user)
    }

    override fun getSavedUser(): Single<EntityUser> {
        return userCache.getSavedUser()
    }

    override fun isLoged(): Boolean {
        return userCache.isLoged()
    }

    override fun logOut(): Completable {
        return userCache.logOut()
    }

    override fun getToken(): String {
        return userCache.getToken()
    }

    override fun saveToken(token: String): Boolean {
        return userCache.saveToken(token)
    }
}