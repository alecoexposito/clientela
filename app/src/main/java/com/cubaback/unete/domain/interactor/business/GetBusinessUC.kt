package com.cubaback.unete.domain.interactor.business

import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.domain.repository.IBusinessRepository
import io.reactivex.Flowable
import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase

open class GetBusinessUC(val businessDataRepository: IBusinessRepository,
                         threadExecutor: ThreadExecutor,
                         postExecutionThread: PostExecutionThread) : FlowableUseCase<List<BusinessBo>, Void?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Void?): Flowable<List<BusinessBo>> {
        return businessDataRepository.getBusinesses()
    }
}