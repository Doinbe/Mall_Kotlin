package com.solin.base.ext

import com.google.gson.Gson
import com.solin.base.data.protocol.BaseRequest
import com.solin.base.rx.BaseSubscriber
import okhttp3.MediaType
import okhttp3.RequestBody
import rx.Observable
import rx.Subscriber

/**
 * Observable 扩展方法
 */

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
    this.subscribeOn(rx.schedulers.Schedulers.io())
            .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}

fun Any.getJsonString(): String{
    return Gson().toJson(this)
}

fun BaseRequest.getRequestBody(): RequestBody {
    return RequestBody.create(MediaType.parse("application/json"),this.getJsonString())
}