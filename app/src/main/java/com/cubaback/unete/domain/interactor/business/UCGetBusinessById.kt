package com.cubaback.unete.domain.interactor.business

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Flowable

class UCGetBusinessById(private val businessDataRepository: IBusinessRepository,
                        threadExecutor: ThreadExecutor,
                        postExecutionThread: PostExecutionThread) : FlowableUseCase<BusinessBo, Long>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Long?): Flowable<BusinessBo> {
       return businessDataRepository.getBusinessById(params!!).toFlowable()
    }


}