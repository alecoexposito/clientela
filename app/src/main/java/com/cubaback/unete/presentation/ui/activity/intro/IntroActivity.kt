package com.cubaback.unete.presentation.ui.activity.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.presentation.ui.activity.main.MainActivity
import com.cubaback.unete.presentation.ui.fragment.IntroFragment
import com.cubaback.unete.presentation.ui.fragment.LoginFragment
import com.cubaback.unete.presentation.ui.fragment.RegisterFragment
import org.jetbrains.anko.startActivity

class IntroActivity : AppCompatActivity(){

    private var loginFragment :  LoginFragment? = null
    private var registerFragment: RegisterFragment? = null

    private val registerListener = object : RegisterFragment.OnRegisterListener{
        override fun registerSuccess() {
            openMainActivity()
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


    private fun openLoginFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        loginFragment = LoginFragment.newInstance()
        loginFragment?.let { it.listener = loginListener }
        loginFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openRegisterFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        registerFragment = RegisterFragment.newInstance()
        registerFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        registerFragment?.let { it.listener = registerListener }
        fragmentTransition.commit()
    }


    fun openMainActivity() {
        startActivity<MainActivity>()
    }
}
