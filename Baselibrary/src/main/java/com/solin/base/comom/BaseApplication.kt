package com.solin.base.comom

import android.app.Application
import com.solin.base.injection.component.AppComponent
import com.solin.base.injection.component.DaggerAppComponent
import com.solin.base.injection.module.AppModule

class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}