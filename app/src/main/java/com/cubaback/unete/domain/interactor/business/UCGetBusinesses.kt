package com.cubaback.unete.domain.interactor.business

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Flowable
import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase

open class UCGetBusinesses(val businessDataRepository: IBusinessRepository,
                           threadExecutor: ThreadExecutor,
                           postExecutionThread: PostExecutionThread) : FlowableUseCase<List<BusinessBo>, Long?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Long?): Flowable<List<BusinessBo>> {
        if(params != null){
            return businessDataRepository.getBusinessesByCategory(params)
        }
        return businessDataRepository.getBusinesses()
    }
}