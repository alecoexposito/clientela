package com.cubaback.unete.presentation.activity.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.R
import com.cubaback.unete.presentation.activity.main.MainActivity
import com.cubaback.unete.presentation.fragment.IntroFragment
import com.cubaback.unete.presentation.fragment.LoginFragment
import com.cubaback.unete.presentation.fragment.RegisterFragment
import org.jetbrains.anko.startActivity

class IntroActivity : AppCompatActivity(),
        IntroFragment.OnIntroFragmentInteractionListener,
        LoginFragment.OnLoginListener{

    private var loginFragment :  LoginFragment? = null
    private var registerFragment: RegisterFragment? = null
    private var introFragment: IntroFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        openIntroFragment()
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

    private fun openIntroFragment(){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        introFragment = IntroFragment.newInstance()
        introFragment?.let { it.listener = this}
        introFragment?.let { fragmentTransition.replace(R.id.fragment_container, it) }
        fragmentTransition.commit()
    }

    // todo: ver si estoy se puede hacer con lambdas...
    override fun onRegisterClick() {
        openRegisterFragment()
    }

    override fun onLoginClick() {
        openLoginFragment()
    }

    override fun openMainActivity() {
        startActivity<MainActivity>()
    }
}
