package com.cubaback.unete.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.presentation.model.UserDataView
import com.cubaback.unete.presentation.ui.fragment.user.LoginFragment
import com.cubaback.unete.presentation.ui.fragment.user.FirstStepRegisterFragment
import com.cubaback.unete.presentation.ui.fragment.user.SecondStepRegisterFragment
import org.jetbrains.anko.startActivity

class IntroActivity : AppCompatActivity(), SecondStepRegisterFragment.RegisterTwoFragmentCallback{

    private var loginFragment :  LoginFragment? = null
    private var registerFragment: FirstStepRegisterFragment? = null
    private var registerStepTwoFragment: SecondStepRegisterFragment? = null

    private val registerListener = object : FirstStepRegisterFragment.OnRegisterListener{
        override fun registerSuccess() {
            openMainActivity()
        }

        override fun registerImcompleted(userView: UserDataView) {
           userView.email?.let { openRegisterStepTwoFragment(it) }
        }
    }

    private val loginListener = object : LoginFragment.OnLoginListener{
        override fun onLoginSuccess() {
            openMainActivity()
        }

        override fun openRegister() {
            openRegisterFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        openLoginFragment()
    }

    private fun openRegisterStepTwoFragment(email : String){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        registerStepTwoFragment = SecondStepRegisterFragment.newInstance(email)
        registerStepTwoFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openLoginFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        loginFragment = LoginFragment.newInstance()
        loginFragment?.let { it.listener = loginListener }
        loginFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openRegisterFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        registerFragment = FirstStepRegisterFragment.newInstance()
        registerFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        registerFragment?.let { it.listener = registerListener }
        fragmentTransition.commit()
    }

    fun openMainActivity() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onRegisterCompleted(userView: UserDataView) {
       openMainActivity()
    }
}
