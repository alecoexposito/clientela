package com.cubaback.unete.cache

import com.cubaback.unete.cache.dao.CachedUserDao
import com.cubaback.unete.cache.db.JoinUsDatabase
import com.cubaback.unete.cache.model.mapper.CachedUserMapper
import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.repository.user.IUserCache
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle

class UserCache(private val cachedUserDao: CachedUserDao,
                private val cachedUserMapper: CachedUserMapper,
                private val preferencesHelper: PreferencesHelper) : IUserCache {

    override fun saveUser(user: EntityUser): Completable {
       return Completable.defer {
           cachedUserDao.insertUser(cachedUserMapper.map(user))
           Completable.complete()
       }
    }

    override fun getSavedUserById(userId : Long): Single<EntityUser> {
        return Single.defer {
            Single.just(cachedUserDao.getUserById(userId))
        }.flatMap {
            Single.just(cachedUserMapper.reverseMap(it))
        }
    }

    override fun getUserSavedByEmail(email: String): Single<EntityUser> {
        return Single.defer {
            Single.just(cachedUserDao.getUserByEmail(email))
        }.flatMap {
            Single.just(cachedUserMapper.reverseMap(it))
        }
    }

    override fun isLoged(): Boolean {
       return !getToken().isEmpty()
    }

    override fun logOut(): Completable {
        return saveToken("").toSingle().toCompletable()
    }

    override fun getToken(): String {
       return preferencesHelper.token
    }

    override fun saveToken(token: String): Boolean {
       preferencesHelper.token = token
       return true
    }
}