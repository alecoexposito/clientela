package com.cubaback.unete.presentation.ui.fragment

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.cubaback.unete.R
import com.cubaback.unete.data.model.UserView
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.view_model.UserViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {

    var passwordVisible : Boolean = false
    val userViewModel : UserViewModel by viewModel()
    var listener : OnRegisterListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.userLiveData.observe(this, Observer {
            it?.let {
                handlerRegister(it.status, it.data, it.message)
            }
        })

        setupUi()
    }

    private fun handlerRegister(status: ResourceState, data: UserView?, message: String?) {
        when(status){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForRegisterSucess(data)
            ResourceState.ERROR -> setupScreenForLoginError(message)
        }
    }

    private fun setupScreenForRegisterSucess(data: UserView?) {
        listener?.let { it.registerSuccess() }
    }

    private fun setupUi(){
        togglePassword.setOnClickListener{togglePassword()}
        btnRegister.setOnClickListener { registerUser() }
    }


    private fun registerUser(){
        userViewModel.registerUser(UserView(null, etName.text.toString(), etLastName.text.toString(),
                etEmail.text.toString(), etPassword.text.toString()))
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
                RegisterFragment().apply {
                }
    }

    interface OnRegisterListener{
        fun registerSuccess()
    }


}
