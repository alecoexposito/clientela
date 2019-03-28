package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.domain.interactor.advertisement.UCGetAdvertisements
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.AdvertisementDataView
import com.cubaback.unete.presentation.model.mapper.AdvertisementViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class AdvertisementViewModel(private val getAdvertisementsUC: UCGetAdvertisements,
                             val advertisementViewMapper: AdvertisementViewMapper) : ViewModel() {

    val advertisementLiveData : MutableLiveData<Resource<List<AdvertisementDataView>>> = MutableLiveData()

    fun getAdvertisement(){
        advertisementLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        getAdvertisementsUC.execute(GetAdvertisementsObserver())
    }


    override fun onCleared() {
        super.onCleared()
        getAdvertisementsUC.dispose()
    }

    /**Observers*/
    inner class GetAdvertisementsObserver : DisposableSubscriber<List<AdvertisementBo>>(){
        override fun onComplete() { }

        override fun onNext(t: List<AdvertisementBo>?) {
            advertisementLiveData.postValue(Resource(ResourceState.SUCCESS, t?.map { advertisementViewMapper.map(it) }, null))
        }

        override fun onError(t: Throwable?) {
            when(t){
                is NoSuchElementException ->   advertisementLiveData.postValue(Resource(ResourceState.SUCCESS, emptyList(), null))
                else -> advertisementLiveData.postValue(Resource(ResourceState.ERROR, null, t?.message))
            }

        }
    }
}