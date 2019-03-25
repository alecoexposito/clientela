package com.cubaback.unete.presentation.ui.activity.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cubaback.unete.presentation.ui.activity.IntroActivity
import com.cubaback.unete.presentation.ui.activity.MainActivity
import com.cubaback.unete.presentation.ui.activity.splash.ui.SplashActivityUi
import com.cubaback.unete.presentation.view_model.UserViewModel
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var splashUi : SplashActivityUi
    private val userViewModel : UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashUi = SplashActivityUi()
        splashUi.setContentView(this)
        val handler = Handler()

        userViewModel.savedToken.observe(this, Observer {
            if(it.isNullOrEmpty()){
                handler.postDelayed({
                    startActivity<IntroActivity>()
                    finish()
                }, 1000)
            } else{
                handler.postDelayed({
                    startActivity<MainActivity>()
                    finish()
                }, 1000)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        userViewModel.getSavedToken()
    }

    }
