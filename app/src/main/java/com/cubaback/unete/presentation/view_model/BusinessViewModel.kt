package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.domain.interactor.business.UCGetBusinessById
import com.cubaback.unete.presentation.model.BusinessDataView
import com.cubaback.unete.domain.interactor.business.UCGetBusinesses
import com.cubaback.unete.domain.model.BusinessBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.mapper.BusinessViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class BusinessViewModel(private val getBusinessUC: UCGetBusinesses,
                        private val ucGetBusinessById: UCGetBusinessById,
                        private val businessViewMapper: BusinessViewMapper) : ViewModel() {

    val businessLiveData : MutableLiveData<Resource<List<BusinessDataView>>> = MutableLiveData()

    val selectedBusiness : MutableLiveData<Resource<BusinessDataView>> = MutableLiveData()


    fun getBusinesses(catId : Long? = null){
        businessLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBusinessUC.execute(GetBusinessesObserver(), catId)
    }

    fun getBusinessById(id : Long){
        selectedBusiness.postValue(Resource(ResourceState.LOADING, null, null))
        return ucGetBusinessById.execute(GetBussinesByIdObserver(), id)
    }

    override fun onCleared() {
        getBusinessUC.dispose()
        ucGetBusinessById.dispose()
        super.onCleared()
    }

    /**Observers*/
    inner class GetBusinessesObserver : DisposableSubscriber<List<BusinessBo>>(){
        override fun onComplete() { }

        override fun onNext(t: List<BusinessBo>?) {
            businessLiveData.postValue(Resource(ResourceState.SUCCESS, t?.map { businessViewMapper.map(it) }, null))
        }

        override fun onError(t: Throwable?) {
            when(t){
                is NoSuchElementException ->    businessLiveData.postValue(Resource(ResourceState.SUCCESS, emptyList(), null))
                else -> businessLiveData.postValue(Resource(ResourceState.ERROR, null , t?.message))
            }

        }
    }

    inner class GetBussinesByIdObserver : DisposableSubscriber<BusinessBo>(){
        override fun onComplete() { }

        override fun onNext(t: BusinessBo?) {
            selectedBusiness.postValue(Resource(ResourceState.SUCCESS, t?.let { businessViewMapper.map(it) }, null))
        }

        override fun onError(t: Throwable?) {
            selectedBusiness.postValue(Resource(ResourceState.ERROR, null, t?.message))
        }
    }
}