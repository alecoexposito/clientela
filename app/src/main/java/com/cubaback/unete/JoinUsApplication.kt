package com.cubaback.unete

import android.app.Application
import org.koin.android.ext.android.get
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

class JoinUsApplication : Application(){

//    val appModule : Module = applicationContext {
//       // bean { AWSAnalyticsService(get()) as IJoinUsService }
//    }


    override fun onCreate() {
        super.onCreate()
        // initialize koin
     //   startKoin(this, listOf(appModule))
    }
}