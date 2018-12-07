package com.solin.base.injection.component

import android.app.Activity
import android.content.Context
import com.solin.base.injection.ActivityScope
import com.solin.base.injection.module.ActivityModule
import com.solin.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent {
    fun context(): Context
    fun activity(): Activity
    fun lifecycleProvider(): LifecycleProvider<*>
}