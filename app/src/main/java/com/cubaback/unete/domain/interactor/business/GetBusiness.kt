package com.cubaback.unete.domain.interactor.business

import com.cubaback.unete.data.model.Business
import com.cubaback.unete.data.repository.impl.BusinessDataRepository
import io.reactivex.Flowable
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.buffer.android.boilerplate.domain.interactor.FlowableUseCase

open class GetBusiness(val businessDataRepository: BusinessDataRepository,
                       threadExecutor: ThreadExecutor,
                       postExecutionThread: PostExecutionThread) : FlowableUseCase<List<Business>, Void?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Void?): Flowable<List<Business>> {
        return businessDataRepository.getBusinesses()
    }
}