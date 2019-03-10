package com.cubaback.unete.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.cubaback.unete.R
import com.cubaback.unete.data.model.UserView
import com.cubaback.unete.presentation.data.ResourceState
import com.cubaback.unete.presentation.view_model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    var listener : OnLoginListener? = null
    val loginViewModel: LoginViewModel by viewModel()

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

        loginViewModel.userLiveData.observe(this, Observer {
            if (it != null) {
                this.handlerLogin(it.status, it.data, it.message)
            }

        })
    }

    private fun handlerLogin(state : ResourceState, data : UserView?, message : String?){
        when (state) {
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForLoginSuccess(data)
            ResourceState.ERROR -> setupScreenForLoginError(message)
        }
    }

    private fun setupScreenForLoginError(message: String?) {
        alert ("Error")
    }

    private fun setupScreenForLoginSuccess(data: UserView?) {
        listener?.let {  it.openMainActivity()}
    }

    private fun setupScreenForLoadingState() {
         toast("Cargando")
    }

    private fun setupUi(){
        btnLogin.setOnClickListener{
            loginViewModel.loginUser(UserView(0, email = etEmail.text.toString(), password = etPassword.text.toString()))
        }

        btnRegister.setOnClickListener {
            listener?.let { it.openRegister() }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance ( ) =
            LoginFragment().apply {  }
    }


    interface OnLoginListener{
        fun openMainActivity()
        fun openRegister()
    }


}
