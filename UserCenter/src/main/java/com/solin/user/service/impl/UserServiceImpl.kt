package com.solin.user.service.impl

import com.solin.user.service.UserService
import rx.Observable

class UserServiceImpl: UserService {
    override fun register(name: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}