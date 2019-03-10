package com.cubaback.unete.domain.repository

import com.cubaback.unete.domain.model.UserBo
import io.reactivex.Completable
import io.reactivex.Single

interface IUserRepository {

    fun login(userBo: UserBo) : Single<UserBo>

    fun register(userBo: UserBo) : Single<UserBo>

    fun saveUser(user : UserBo) : Completable

    fun getSavedUser() : Single<UserBo>

    fun logOut() : Completable

    fun getToken() : String

    fun saveToken(token : String) : Boolean

}