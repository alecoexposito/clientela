package com.cubaback.unete.presentation.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cubaback.unete.R
import com.cubaback.unete.domain.interactor.user.UCGetCurrentUser
import com.cubaback.unete.domain.interactor.user.UCGetUserByEmail
import com.cubaback.unete.domain.model.UserBo
import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.domain.interactor.user.UCLogin
import com.cubaback.unete.domain.interactor.user.UCRegister
import com.cubaback.unete.presentation.data.Resource
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.model.mapper.UserViewMapper
import io.reactivex.subscribers.DisposableSubscriber

class UserViewModel(private val loginUC: UCLogin,
                    private val registerUC: UCRegister,
                    private val getUserByIdUC: UCGetUserByEmail,
                    private val getCurrentUserUC: UCGetCurrentUser,
                    val userViewMapper: UserViewMapper) : ViewModel() {


    val registeredAndLoguedUser: MutableLiveData<Resource<UserDataView>> = MutableLiveData()
    val savedUser: MutableLiveData<Resource<UserDataView>> = MutableLiveData()
    val savedToken: MutableLiveData<String> = MutableLiveData()


    fun loginUser(userView: UserDataView){
        registeredAndLoguedUser.postValue(Resource(ResourceState.LOADING, null, null))
        return loginUC.execute(LoginAndRegisterObserver(), userViewMapper.reverseMap(userView))
    }

    fun registerUser(context: Context, userView: UserDataView){
        val msg = validateRegisterInput(context, userView)
        if(msg.isNullOrEmpty()){
            registeredAndLoguedUser.postValue(Resource(ResourceState.LOADING, null, null))
            return registerUC.execute(LoginAndRegisterObserver(), userViewMapper.reverseMap(userView))
        } else{
            registeredAndLoguedUser.postValue(Resource(ResourceState.ERROR, null, msg))
        }
    }

    fun getSavedToken(){
        savedToken.postValue(getCurrentUserUC.getCurrentToken())
    }

    private fun validateRegisterInput(context : Context, userView: UserDataView) : String{
        var message : String = ""

        if(!userView.isCompleted!!){
            if(userView.name.isNullOrEmpty()){
                message = "${context.getString(R.string.empty_field_error, context.getString(R.string.name))} \n"
            }

            if(userView.lastName.isNullOrEmpty()){
                message += "${context.getString(R.string.empty_field_error, context.getString(R.string.last_name))} \n"
            }

            if (userView.email.isNullOrEmpty()){
                message += "${context.getString(R.string.empty_field_error, context.getString(R.string.email))} \n"
            }

            if (userView.password.isNullOrEmpty()){
                message += "${context.getString(R.string.empty_field_error, context.getString(R.string.password))} "
            }
        } else{
            if(userView.birdDate.toString().isNullOrEmpty()){
                message += "${context.getString(R.string.empty_field_error, context.getString(R.string.birth_date))} \n"
            }

            if(userView.phone.isNullOrEmpty()){
                message += "${context.getString(R.string.empty_field_error, context.getString(R.string.phone_number))} \n"
            }
        }


        return message
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
            registeredAndLoguedUser.postValue(Resource(ResourceState.ERROR, null, exception.message))
        }
    }


    inner class SavedObserver : DisposableSubscriber<UserBo>(){
        override fun onComplete() {}

        override fun onNext(t: UserBo?) {
            savedUser.postValue(Resource(ResourceState.SUCCESS, t?.let { userViewMapper.map(it) }, null))
        }

        override fun onError(exception: Throwable) {

            savedUser.postValue(Resource(ResourceState.ERROR, null, exception.message))
        }
    }


}