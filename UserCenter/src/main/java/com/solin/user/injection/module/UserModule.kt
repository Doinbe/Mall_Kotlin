package com.solin.user.injection.module

import com.solin.user.service.UserService
import com.solin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService{
        return service
    }
}