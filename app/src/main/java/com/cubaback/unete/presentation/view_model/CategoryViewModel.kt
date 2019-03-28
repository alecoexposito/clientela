package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.presentation.model.CategoryDataView
import com.cubaback.unete.domain.interactor.category.UCGetCategories
import com.cubaback.unete.domain.model.CategoryBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.mapper.CategoryViewMapper
import io.reactivex.subscribers.DisposableSubscriber

open class CategoryViewModel(private val getCategoriesUC: UCGetCategories,
                             private val categoryViewMapper: CategoryViewMapper) : ViewModel() {

    val categoriesLiveData : MutableLiveData<Resource<List<CategoryDataView>>> = MutableLiveData()

    // Solo para sub categorias...
    val subCategoriesLiveData : MutableLiveData<List<CategoryDataView>> = MutableLiveData()


    fun getCategories(){
        getCategoriesUC.execute(GetCategoriesObserver())
    }

    override fun onCleared() {
        getCategoriesUC.dispose()
        super.onCleared()
    }


    fun fillSubCategories(parentId : Long){
        getCategoriesUC.execute(GetCategoriesObserver(), parentId)
    }



    /*Observers*/
    inner class GetCategoriesObserver : DisposableSubscriber<List<CategoryBo>>(){
        override fun onComplete() {}

        override fun onNext(t: List<CategoryBo>?) {
           categoriesLiveData.postValue(Resource(ResourceState.SUCCESS, t?.map { categoryViewMapper.map(it) }, null))
        }

        override fun onError(t: Throwable?) {
            categoriesLiveData.postValue(Resource(ResourceState.ERROR,null, t?.message))
        }
    }
}