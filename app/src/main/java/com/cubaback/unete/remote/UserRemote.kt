package com.cubaback.unete.remote

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.repository.user.IUserRemote
import com.cubaback.unete.remote.model.mapper.ModelUserMapper
import io.reactivex.Single

open class UserRemote(private val joinService: IJoinUsService,
                      private val modelUserMapper : ModelUserMapper) : IUserRemote {

    override fun register(user: EntityUser): Single<EntityUser> {
        return joinService.register(modelUserMapper.reverseMap(user))
                .flatMap {
                    Single.just(modelUserMapper.map(it))
                }
    }

    override fun login(user: EntityUser): Single<EntityUser> {
        return joinService.login(modelUserMapper.reverseMap(user)  )
                .flatMap {
                    Single.just(modelUserMapper.map(it))
                }
    }

}