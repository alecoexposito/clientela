package com.cubaback.unete.domain.interactor.user

import com.cubaback.unete.domain.repository.IUserRepository

/**
 * Get current user saved (last token)
 * */
class UCGetCurrentUser(private val userRepository: IUserRepository)  {

    // todo: Change it to get current user
    fun getCurrentToken() : String {
        return userRepository.getToken()
    }


}