package com.cubaback.unete.presentation.ui.activity.splash.ui

import android.view.Gravity
import android.view.View
import com.cubaback.unete.R
import com.cubaback.unete.presentation.ui.activity.splash.SplashActivity
import org.jetbrains.anko.*

class SplashActivityUi : AnkoComponent<SplashActivity>{

   // setup Ui components...
    override fun createView(ui: AnkoContext<SplashActivity>): View {
         return with(ui){
             verticalLayout {
                 this.gravity = Gravity.CENTER

                 imageView(R.drawable.join_ui_logo){
                     this@verticalLayout.gravity = Gravity.CENTER
                 }.lparams(width = dip(256), height = dip(256))

                 textView(R.string.text_logo){
                     gravity = Gravity.CENTER
                 }.lparams(width = wrapContent, height = wrapContent)

                 textView(R.string.slogan){
                     gravity = Gravity.CENTER
                 }.lparams(width = wrapContent, height = wrapContent)
             }
         }
    }
}