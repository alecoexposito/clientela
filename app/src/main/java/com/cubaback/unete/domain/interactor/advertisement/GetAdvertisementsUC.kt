package com.cubaback.unete.domain.interactor.advertisement

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.domain.repository.IAdvertisementRepository
import io.reactivex.Flowable

class GetAdvertisementsUC(val advertisementRepository: IAdvertisementRepository,
                          threadExecutor: ThreadExecutor,
                          postExecutionThread: PostExecutionThread) :  FlowableUseCase<List<AdvertisementBo>, Void?>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Flowable<List<AdvertisementBo>> {
        return advertisementRepository.getAdvertisements()
    }
}