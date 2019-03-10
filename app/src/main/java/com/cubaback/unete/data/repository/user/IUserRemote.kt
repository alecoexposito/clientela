package com.cubaback.unete.data.repository.user

import com.cubaback.unete.data.model.EntityBusiness
import com.cubaback.unete.data.model.EntityUser
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Repositorio de negocios para interactuar con el API
 * */
interface IUserRemote {

    fun register(user : EntityUser) : Single<EntityUser>

    fun login(user : EntityUser): Single<EntityUser>

}