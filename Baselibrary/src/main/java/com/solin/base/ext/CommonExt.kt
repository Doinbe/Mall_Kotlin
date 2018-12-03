package com.solin.base.ext

import com.solin.base.rx.BaseSubscriber
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