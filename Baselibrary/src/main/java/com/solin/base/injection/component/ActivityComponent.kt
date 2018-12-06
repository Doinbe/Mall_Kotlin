package com.solin.base.injection.component

import android.app.Activity
import com.solin.base.injection.ActivityScope
import com.solin.base.injection.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity(): Activity
}