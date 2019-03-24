package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.domain.interactor.advertisement.GetAdvertisementsUC
import com.cubaback.unete.domain.model.AdvertisementBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.AdvertisementView
import com.cubaback.unete.presentation.model.mapper.AdvertisementViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class AdvertisementViewModel(private val getAdvertisementsUC: GetAdvertisementsUC,
                             val advertisementViewMapper: AdvertisementViewMapper) : ViewModel() {

    val advertisementLiveData : MutableLiveData<Resource<List<AdvertisementView>>> = MutableLiveData()

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
            advertisementLiveData.postValue(Resource(ResourceState.ERROR, null, t?.message))
        }
    }
}