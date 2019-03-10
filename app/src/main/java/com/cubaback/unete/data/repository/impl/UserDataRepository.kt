package com.cubaback.unete.data.repository.impl

import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.data.model.mapper.EntityUserMapper
import com.cubaback.unete.data.sources.user.UserDataStoreFactory
import com.cubaback.unete.domain.repository.IUserRepository
import com.cubaback.unete.presentation.untils.Utils
import io.reactivex.Completable
import io.reactivex.Single

class UserDataRepository(private val factory : UserDataStoreFactory,
                         private val userEntityUserMapper: EntityUserMapper) : IUserRepository {

    override fun login(userBo: UserBo): Single<UserBo> {
        return factory.retrieveRemoteDataStore().login(userEntityUserMapper.reverseMap(userBo))
                .flatMap {
                    Single.just(userEntityUserMapper.map(it))
                }
                .doAfterSuccess {
                    it.token?.let {
                        it1 -> saveToken(it1)
                        Utils.token = it.token
                    }
                }
    }

    override fun register(userBo: UserBo): Single<UserBo> {
        return factory.retrieveRemoteDataStore().register(userEntityUserMapper.reverseMap(userBo))
                .flatMap {
                    Single.just(userEntityUserMapper.map(it))
                }
                .flatMap {
                    saveUser(it).toSingle{it}
                }
    }

    override fun saveUser(user: UserBo): Completable {
        return factory.retrieveCacheDataStore().saveUser(userEntityUserMapper.reverseMap(user))
    }

    override fun getSavedUser(): Single<UserBo> {
        return factory.retrieveCacheDataStore().getSavedUser()
                .flatMap {
                    Single.just(userEntityUserMapper.map(it))
                }
    }

    override fun logOut(): Completable {
        return factory.retrieveCacheDataStore().logOut()
    }

    override fun getToken(): String {
       Utils.token =  factory.retrieveCacheDataStore().getToken()
       return Utils.token
    }

    override fun saveToken(token: String): Boolean {
        return factory.retrieveCacheDataStore().saveToken(token)
    }
}