package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.data.model.UserView
import com.cubaback.unete.domain.interactor.user.LoginUC
import com.cubaback.unete.domain.interactor.user.RegisterUC
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.mapper.UserViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class UserViewModel(private val loginUC: LoginUC,
                    private val registerUC: RegisterUC,
                    val userViewMapper: UserViewMapper) : ViewModel() {


    val userLiveData: MutableLiveData<Resource<UserView>> = MutableLiveData()


    fun loginUser(userView: UserView){
        userLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return loginUC.execute(LoginObserver(), userViewMapper.reverseMap(userView))
    }

    fun registerUser(userView: UserView){
        userLiveData.postValue(Resource(ResourceState.LOADING, null, null))
        return registerUC.execute(LoginObserver(), userViewMapper.reverseMap(userView))
    }


    override fun onCleared() {
        loginUC.dispose()
         super.onCleared()
    }


    /*Observers*/
    inner class LoginObserver : DisposableSubscriber<UserBo>(){
        override fun onComplete() {}

        override fun onNext(t: UserBo?) {
            userLiveData.postValue(Resource(ResourceState.SUCCESS, t?.let { userViewMapper.map(it) }, null))
        }

        override fun onError(exception: Throwable) {

            userLiveData.postValue(Resource(ResourceState.ERROR, null, exception.message))
        }
    }
}