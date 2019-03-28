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
import com.cubaback.unete.presentation.ui.fragment.BaseFragment
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
                handlerRegister(it.status, it.data, it.message)
            }
        })

        setupUi()
    }

    private fun handlerRegister(status: ResourceState, data: UserDataView?, message: String?) {
        when(status){
            ResourceState.LOADING -> setupScreenForLoadingState()
            ResourceState.SUCCESS -> setupScreenForRegisterSucess(data)
            ResourceState.ERROR -> setupScreenForError(message)
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
                dismissLoading()
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
        activity?.let { userViewModel.registerUser(it, UserDataView(null, name, lastName, email, password)) }
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
