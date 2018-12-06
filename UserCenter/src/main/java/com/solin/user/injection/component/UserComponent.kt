package com.solin.user.injection.component

import com.solin.base.injection.PreComponentScope
import com.solin.base.injection.component.ActivityComponent
import com.solin.user.injection.module.UserModule
import com.solin.user.ui.activity.RegisterActivity
import dagger.Component

@PreComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}