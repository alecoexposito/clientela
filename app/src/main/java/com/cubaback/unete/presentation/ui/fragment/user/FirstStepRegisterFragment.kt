package com.cubaback.unete.presentation.ui.fragment.user

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.ui.activity.BaseActivity
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
import com.cubaback.unete.presentation.view_model.UserAction
import com.cubaback.unete.presentation.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_register_step_one.*
import org.koin.android.viewmodel.ext.android.viewModel

class FirstStepRegisterFragment : BaseFragment() {

    var passwordVisible : Boolean = false
    val userViewModel : UserViewModel by viewModel()
    var listener : OnRegisterListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.registeredAndLoguedUser.observe(this, Observer {
            it?.let {
                handlerRegister(it.status, it.data, it.throwable)
            }
        })

        setupUi()
    }

    private fun handlerRegister(status: ResourceState, data: UserDataView?, t: Throwable?) {
        when(status){
            ResourceState.LOADING ->  (activity as BaseActivity).setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForRegisterSucess(data)
            ResourceState.ERROR -> (activity as BaseActivity).handlerError(t!!)
        }
    }

    private fun setupScreenForRegisterSucess(data: UserDataView?) {
        listener?.let {
            data?.apply {
                this.isCompleted?.let {it1->
                    if(it1){
                        it.registerSuccess()
                    } else{
                        it.registerImcompleted(data)
                    }
                }
                (activity as BaseActivity).dismissLoading()
            }
        }

    }

    private fun setupUi(){
        togglePassword.setOnClickListener{togglePassword()}
        btnRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val name = etName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val user =  UserDataView(null, name, lastName, email, password)

        if (userViewModel.isValid(user, UserAction.REGISTER)){
            userViewModel.registerUser(user)
        } else{
            var message = ""
            if(user.name.isNullOrEmpty()){
                message = "${getString(R.string.empty_field_error, getString(R.string.name))} \n"
            }

            if(user.lastName.isNullOrEmpty()){
                message += "${getString(R.string.empty_field_error, getString(R.string.last_name))} \n"
            }

            if (user.email.isNullOrEmpty()){
                message += "${getString(R.string.empty_field_error, getString(R.string.email))} \n"
            }

            if (user.password.isNullOrEmpty()){
                message += "${getString(R.string.empty_field_error, getString(R.string.password))} "
            }
            (activity as BaseActivity).setupScreenForError(message)
        }
    }


    private fun togglePassword(){
        val hidePass = PasswordTransformationMethod()
        if(!passwordVisible){
            etPassword.transformationMethod = null
            togglePassword.setBackgroundResource(R.drawable.ic_visibility_off)
        } else{
            etPassword.transformationMethod = hidePass
            togglePassword.setBackgroundResource(R.drawable.ic_visibility)
        }
        passwordVisible = !passwordVisible
    }

    companion object {
        @JvmStatic
        fun newInstance( ) =
                FirstStepRegisterFragment().apply {
                }
    }

    interface OnRegisterListener{
        fun registerSuccess()
        fun registerImcompleted(userView: UserDataView)
    }


}
