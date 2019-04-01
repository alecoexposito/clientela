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
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    lateinit var listener : OnLoginListener
    val loginViewModel: UserViewModel by viewModel()
    var passwordVisible : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()

        loginViewModel.registeredAndLoguedUser.observe(this, Observer {
            if (it != null) {
                this.handlerLogin(it.status, it.data, it.throwable)
            }

        })
    }

    private fun handlerLogin(state : ResourceState, data : UserDataView?, t : Throwable?){
        when (state) {
            ResourceState.LOADING ->  (activity as BaseActivity).setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForLoginSuccess(data)
            ResourceState.ERROR -> (activity as BaseActivity).handlerError(t!!)
        }
    }


    private fun setupScreenForLoginSuccess(data: UserDataView?) {
        listener?.let {
            it.onLoginSuccess()
            (activity as BaseActivity).dismissLoading()
        }
    }



    private fun setupUi(){
        btnLogin.setOnClickListener{
            val email =  etEmail.text.toString()
            val password = etPassword.text.toString()
            val user = UserDataView(0, email = email, password = password)
            if(loginViewModel.isValid(user, UserAction.LOGIN)){
                loginViewModel.loginUser(user)
            }else{
                var message = ""
                if (user.email.isNullOrEmpty()){
                    message += "${getString(R.string.empty_field_error, getString(R.string.email))} \n"
                }

                if (user.password.isNullOrEmpty()){
                    message += "${getString(R.string.empty_field_error, getString(R.string.password))} "
                }
                (activity as BaseActivity).setupScreenForError(message)
            }

        }

        btnRegister.setOnClickListener {
            listener?.let { it.openRegister() }
        }

        togglePassword.setOnClickListener{togglePassword()}
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
        fun newInstance ( ) =
            LoginFragment().apply {  }
    }


    interface OnLoginListener{
        fun onLoginSuccess()
        fun openRegister()
    }


}
