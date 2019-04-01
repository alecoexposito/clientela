package com.cubaback.unete.domain.interactor.user

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.CompletableUseCase
import com.cubaback.unete.domain.repository.IUserRepository
import io.reactivex.Completable

open class UCLogout(val userDataRepository: IUserRepository,
               threadExecutor: ThreadExecutor,
               porExecutionThread: PostExecutionThread) : CompletableUseCase<Unit?>(threadExecutor, porExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Completable {
       return userDataRepository.logOut()
    }
}