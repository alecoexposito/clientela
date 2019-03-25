package com.cubaback.unete.domain.interactor.category

import com.cubaback.unete.domain.executor.PostExecutionThread
import com.cubaback.unete.domain.executor.ThreadExecutor
import com.cubaback.unete.domain.interactor.base.FlowableUseCase
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.domain.repository.ICategoryRepository
import io.reactivex.Flowable

open class UCGetCategories(private val categoryRepository: ICategoryRepository,
                           threadExecutor: ThreadExecutor,
                           postExecutionThread: PostExecutionThread) : FlowableUseCase<List<CategoryBo>, Long?>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservable(params: Long?): Flowable<List<CategoryBo>> {
        if(params != null){
            return categoryRepository.getCategoriesByParentId(params)
        } else{
            return categoryRepository.getCategories()
        }
    }
}