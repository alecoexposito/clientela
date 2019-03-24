package com.cubaback.unete.data.repository.domain_repository_impl

import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.data.model.mapper.EntityUserMapper
import com.cubaback.unete.data.sources.user.UserDataStoreFactory
import com.cubaback.unete.domain.repository.IUserRepository
import com.cubaback.unete.presentation.utils.Utils
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
                        Utils.token = it1
                    }
                }
    }

    /**
     *  Iif register is completed send it to Remote API
     *  otherwise just save the user in cache and return it
     * */
    override fun register(userBo: UserBo): Single<UserBo> {
        if(userBo.isCompleted!!){
            return factory.retrieveRemoteDataStore().register(userEntityUserMapper.reverseMap(userBo))
                    .flatMap {
                        Single.just(userEntityUserMapper.map(it))
                    } .doAfterSuccess {
                        it.token?.let {
                            it1 -> saveToken(it1)
                            Utils.token = it1
                        }
                    }
                    .flatMap {
                        saveUser(it).toSingle{it}
                    }
        }
        return factory.retrieveCacheDataStore().saveUser(userEntityUserMapper.reverseMap(userBo)).andThen(
                Single.just(userBo)
        )

    }

    override fun saveUser(user: UserBo): Completable {
        return factory.retrieveCacheDataStore().saveUser(userEntityUserMapper.reverseMap(user))
    }

    override fun getSavedUserById(userId : Long): Single<UserBo> {
        return factory.retrieveCacheDataStore().getSavedUserById(userId)
                .flatMap {
                    Single.just(userEntityUserMapper.map(it))
                }
    }


    override fun getSavedUserByEmail(email: String): Single<UserBo> {
        return factory.retrieveCacheDataStore().getSavedUserByEmail(email)
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