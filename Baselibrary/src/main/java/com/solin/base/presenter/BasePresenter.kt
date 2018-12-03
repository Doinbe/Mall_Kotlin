package com.solin.base.presenter

import com.solin.base.presenter.view.BaseView

open class BasePresenter<T :BaseView> {
    lateinit var mView: T

}