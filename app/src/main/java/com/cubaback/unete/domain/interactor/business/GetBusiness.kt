package com.cubaback.unete.domain.interactor.business

import com.cubaback.unete.data.model.BusinessBo
import com.cubaback.unete.data.repository.impl.BusinessDataRepository
import io.reactivex.Flowable
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.buffer.android.boilerplate.domain.interactor.FlowableUseCase

open class GetBusiness(val businessDataRepository: BusinessDataRepository,
                       threadExecutor: ThreadExecutor,
                       postExecutionThread: PostExecutionThread) : FlowableUseCase<List<BusinessBo>, Void?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Void?): Flowable<List<BusinessBo>> {
        return businessDataRepository.getBusinesses()
    }
}