package com.solin.user.data.repository

import com.solin.base.data.net.RetrofitFactory
import com.solin.base.data.protocol.BaseResponse
import com.solin.user.data.api.UserApi
import okhttp3.RequestBody
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {
    fun register(request: RequestBody): Observable<BaseResponse<String>>{
        return RetrofitFactory.intance.create(UserApi::class.java)
                .register(request)
    }
}