package com.cubaback.unete.presentation.activity.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cubaback.unete.presentation.activity.intro.IntroActivity
import com.cubaback.unete.presentation.activity.splash.ui.SplashActivityUi
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    lateinit var splashUi : SplashActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashUi = SplashActivityUi()
        splashUi.setContentView(this)

        val handler : Handler = Handler()
        handler.postDelayed({startActivity<IntroActivity>()}, 1000)

    }
}
