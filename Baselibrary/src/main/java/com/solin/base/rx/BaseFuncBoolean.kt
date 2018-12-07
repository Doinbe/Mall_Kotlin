package com.solin.base.rx

import com.solin.base.data.protocol.BaseResponse
import rx.Observable
import rx.functions.Func1

class BaseFuncBoolean<T>: Func1<BaseResponse<T>,Observable<Boolean>>{
    override fun call(t: BaseResponse<T>): Observable<Boolean> {
        if (t.status != 0)  return Observable.error(BaseException(t.status,t.message))
        return Observable.just(true)
    }

}