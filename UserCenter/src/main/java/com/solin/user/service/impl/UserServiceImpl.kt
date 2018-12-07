package com.solin.user.service.impl

import com.solin.base.data.protocol.BaseResponse
import com.solin.base.ext.convertBoolean
import com.solin.base.rx.BaseException
import com.solin.base.rx.BaseFuncBoolean
import com.solin.user.data.repository.UserRepository
import com.solin.user.service.UserService
import okhttp3.RequestBody
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository: UserRepository

    override fun register(request: RequestBody): Observable<Boolean> {
        return userRepository.register(request)
                .convertBoolean()
    }
}