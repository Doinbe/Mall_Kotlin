package com.solin.base.ext

import com.google.gson.Gson
import com.solin.base.data.protocol.BaseRequest
import com.solin.base.data.protocol.BaseResponse
import com.solin.base.rx.BaseFunc
import com.solin.base.rx.BaseFuncBoolean
import com.solin.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import okhttp3.MediaType
import okhttp3.RequestBody
import rx.Observable

/**
 * Observable 扩展方法
 */

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>){
    this.subscribeOn(rx.schedulers.Schedulers.io())
            .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}

fun <T> Observable<BaseResponse<T>>.convert(): Observable<T>{
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResponse<T>>.convertBoolean(): Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

fun Any.getJsonString(): String{
    return Gson().toJson(this)
}

fun BaseRequest.getRequestBody(): RequestBody {
    return RequestBody.create(MediaType.parse("application/json"),this.getJsonString())
}