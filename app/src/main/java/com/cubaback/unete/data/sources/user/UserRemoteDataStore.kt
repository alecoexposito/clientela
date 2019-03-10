package com.cubaback.unete.data.sources.user

import com.cubaback.unete.data.model.EntityUser
import com.cubaback.unete.data.repository.user.IUserDataStore
import com.cubaback.unete.data.repository.user.IUserRemote
import io.reactivex.Completable
import io.reactivex.Single

open class UserRemoteDataStore(val userRemote: IUserRemote) : IUserDataStore {

    override fun register(user: EntityUser): Single<EntityUser> {
        return userRemote.register(user)
    }

    override fun login(user: EntityUser): Single<EntityUser> {
        return userRemote.login(user)
    }

    override fun saveUser(user: EntityUser): Completable {
        throw UnsupportedOperationException()
    }

    override fun getSavedUser(): Single<EntityUser> {
        throw UnsupportedOperationException()
    }

    override fun isLoged(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun logOut(): Completable {
        throw UnsupportedOperationException()
    }

    override fun getToken(): String {
        throw UnsupportedOperationException()
    }

    override fun saveToken(token: String): Boolean {
        throw UnsupportedOperationException()
    }
}