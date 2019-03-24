package com.cubaback.unete.domain.interactor.user

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.domain.repository.IUserRepository
import io.reactivex.Flowable

open class GetUserByEmailUC(private val userRepository: IUserRepository,
                            threadExecutor: ThreadExecutor,
                            postExecutionThread: PostExecutionThread) : FlowableUseCase<UserBo, String?>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: String?): Flowable<UserBo> {
        return params?.let { userRepository.getSavedUserByEmail(it).toFlowable()} as Flowable<UserBo>
    }
}