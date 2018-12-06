package com.solin.user.data.api

import com.solin.base.data.protocol.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi{

    @POST("userCenter/register")
    fun register(@Body request: RequestBody): Observable<BaseResponse<String>>

}