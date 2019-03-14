package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.data.model.BusinessView
import com.cubaback.unete.domain.interactor.business.GetBusinessUC
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.mapper.BusinessViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class BusinessViewModel(private val getBusinessUC: GetBusinessUC,
                        private val businessViewMapper: BusinessViewMapper) : ViewModel() {

    val businessLiveData : MutableLiveData<Resource<List<BusinessView>>> = MutableLiveData()


//    init {
//        getBusinesses()
//    }

    fun getBusinesses(){
        businessLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBusinessUC.execute(GetBusinessesObserver())
    }

    override fun onCleared() {
        getBusinessUC.dispose()
        super.onCleared()
    }

    /*Observers*/
    inner class GetBusinessesObserver : DisposableSubscriber<List<BusinessBo>>(){
        override fun onComplete() { }

        override fun onNext(t: List<BusinessBo>?) {
            businessLiveData.postValue(Resource(ResourceState.SUCCESS, t?.map { businessViewMapper.map(it) }, null))
        }

        override fun onError(t: Throwable?) {
            businessLiveData.postValue(Resource(ResourceState.ERROR, null , t?.message))
        }
    }
}