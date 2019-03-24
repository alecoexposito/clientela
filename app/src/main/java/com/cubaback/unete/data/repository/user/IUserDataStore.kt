package com.cubaback.unete.data.repository.user

import com.cubaback.unete.data.model.EntityUser
import io.reactivex.Completable
import io.reactivex.Single

interface IUserDataStore {

    fun register(user : EntityUser) : Single<EntityUser>

    fun login(user : EntityUser): Single<EntityUser>

    fun saveUser(user : EntityUser) : Completable

    fun getSavedUserById(userId : Long) : Single<EntityUser>

    fun isLoged() : Boolean

    fun logOut() : Completable

    fun getToken() : String

    fun saveToken(token : String) : Boolean

    fun getSavedUserByEmail(email: String): Single<EntityUser>
}