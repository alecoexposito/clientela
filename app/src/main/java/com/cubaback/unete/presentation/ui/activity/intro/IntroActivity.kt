package com.cubaback.unete.presentation.ui.activity.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.presentation.ui.activity.main.MainActivity
import com.cubaback.unete.presentation.ui.fragment.IntroFragment
import com.cubaback.unete.presentation.ui.fragment.LoginFragment
import com.cubaback.unete.presentation.ui.fragment.RegisterFragment
import org.jetbrains.anko.startActivity

class IntroActivity : AppCompatActivity(),
        LoginFragment.OnLoginListener{

    private var loginFragment :  LoginFragment? = null
    private var registerFragment: RegisterFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        openLoginFragment()
    }


    private fun openLoginFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        loginFragment = LoginFragment.newInstance()
        loginFragment?.let { it.listener = this}
        loginFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    private fun openRegisterFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        registerFragment = RegisterFragment.newInstance()
        registerFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    override fun openRegister() {
        openRegisterFragment()
    }

    override fun openMainActivity() {
        startActivity<MainActivity>()
    }
}
