package com.solin.user.service

import rx.Observable

interface UserService {
    fun register(name: String,pwd: String): Observable<Boolean>
}