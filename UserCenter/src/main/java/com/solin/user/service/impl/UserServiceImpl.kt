package com.solin.user.service.impl

import com.solin.base.data.protocol.BaseResponse
import com.solin.base.rx.BaseException
import com.solin.user.data.repository.UserRepository
import com.solin.user.service.UserService
import okhttp3.RequestBody
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository: UserRepository

    override fun register(request: RequestBody): Observable<Boolean> {
        return userRepository.register(request)
                .flatMap(object :Func1<BaseResponse<String>,Observable<Boolean>>{
                    override fun call(t: BaseResponse<String>): Observable<Boolean> {
                        if (t.status != 0)  return Observable.error(BaseException(t.status,t.message))
                        return Observable.just(true)
                    }
                })
    }
}