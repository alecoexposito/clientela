package com.cubaback.unete.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.domain.interactor.user.*
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.presentation.model.mapper.UserViewMapper
import io.reactivex.subscribers.DisposableSubscriber

enum class UserAction {
    REGISTER, LOGIN
}
class UserViewModel(private val loginUC: UCLogin,
                    private val registerUC: UCRegister,
                    private val getUserByIdUC: UCGetUserByEmail,
                    private val getCurrentUserUC: UCGetCurrentUser,
                    private val ucLogout: UCLogout,
                    val userViewMapper: UserViewMapper) : ViewModel() {


    val registeredAndLoguedUser: MutableLiveData<Resource<UserDataView>> = MutableLiveData()
    val savedUser: MutableLiveData<Resource<UserDataView>> = MutableLiveData()
    val savedToken: MutableLiveData<String> = MutableLiveData()


    fun loginUser(userView: UserDataView){
        registeredAndLoguedUser.postValue(Resource(ResourceState.LOADING, null, null))
        return loginUC.execute(LoginAndRegisterObserver(), userViewMapper.reverseMap(userView))
    }

    fun registerUser(userView: UserDataView){
        registeredAndLoguedUser.postValue(Resource(ResourceState.LOADING, null, null))
        return registerUC.execute(LoginAndRegisterObserver(), userViewMapper.reverseMap(userView))
    }

    fun getSavedToken(){
        savedToken.postValue(getCurrentUserUC.getCurrentToken())
    }

    fun isValid(userView: UserDataView, userAction: UserAction) : Boolean{
        return if(userAction == UserAction.REGISTER){
            if(!userView.isCompleted!!){
                (!userView.name.isNullOrEmpty()
                        && !userView.lastName.isNullOrEmpty()
                        && !userView.email.isNullOrEmpty()
                        && !userView.password.isNullOrEmpty())

            } else{
                (!userView.birdDate.toString().isNullOrEmpty()
                        && !userView.phone.isNullOrEmpty())

            }
        } else{
             !userView.email.isNullOrEmpty() && !userView.password.isNullOrEmpty()
        }

    }

    fun logOut(){
        ucLogout.execute(null)
    }

    fun getUserByEmail(email : String){
        savedUser.postValue(Resource(ResourceState.LOADING, null, null))
        return getUserByIdUC.execute(SavedObserver(), email)
    }


    override fun onCleared() {
        loginUC.dispose()
        registerUC.dispose()
        getUserByIdUC.dispose()
         super.onCleared()
    }


    /**Observers*/
    inner class LoginAndRegisterObserver : DisposableSubscriber<UserBo>(){
        override fun onComplete() {}

        override fun onNext(t: UserBo?) {
            registeredAndLoguedUser.postValue(Resource(ResourceState.SUCCESS, t?.let { userViewMapper.map(it) }, null))
        }

        override fun onError(exception: Throwable) {
            registeredAndLoguedUser.postValue(Resource(ResourceState.ERROR, null, exception))
        }
    }


    inner class SavedObserver : DisposableSubscriber<UserBo>(){
        override fun onComplete() {}

        override fun onNext(t: UserBo?) {
            savedUser.postValue(Resource(ResourceState.SUCCESS, t?.let { userViewMapper.map(it) }, null))
        }

        override fun onError(exception: Throwable) {

            savedUser.postValue(Resource(ResourceState.ERROR, null, exception))
        }
    }


}