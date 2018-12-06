package com.solin.base.injection.module

import android.content.Context
import com.solin.base.comom.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context{
        return context
    }

}