package com.cubaback.unete.domain.interactor.category

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.domain.repository.ICategoryRepository
import io.reactivex.Flowable

open class GetCategoriesUC(private val categoryRepository: ICategoryRepository,
                           threadExecutor: ThreadExecutor,
                           postExecutionThread: PostExecutionThread) : FlowableUseCase<List<CategoryBo>, Void?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Void?): Flowable<List<CategoryBo>> {
        return categoryRepository.getCategories()
    }
}