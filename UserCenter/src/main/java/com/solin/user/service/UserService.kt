package com.solin.user.service

import okhttp3.RequestBody
import rx.Observable

interface UserService {
    fun register(request: RequestBody): Observable<Boolean>
}