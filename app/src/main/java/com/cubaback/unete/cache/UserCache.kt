package com.cubaback.unete.cache

import com.cubaback.unete.cache.model.CachedUser
import com.cubaback.unete.cache.model.mapper.CachedUserMapper
import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.repository.user.IUserCache
import com.vicpin.krealmextensions.createOrUpdate
import com.vicpin.krealmextensions.queryFirst
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle

class UserCache(private val cachedUserMapper: CachedUserMapper,
                private val preferencesHelper: PreferencesHelper) : IUserCache {

    override fun saveUser(user: EntityUser): Completable {
       return Completable.defer {
           cachedUserMapper.map(user).createOrUpdate()
           Completable.complete()
       }
    }

    override fun getSavedUserById(userId : Long): Single<EntityUser> {
        return Single.defer {
            Single.just(CachedUser().queryFirst { this.equalTo("id", userId) })
        }.flatMap {
            Single.just(cachedUserMapper.reverseMap(it))
        }
    }

    override fun getUserSavedByEmail(email: String): Single<EntityUser> {
        return Single.defer {
            Single.just(CachedUser().queryFirst { this.equalTo("email", email) })
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