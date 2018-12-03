package com.solin.base.ui.activity

import com.solin.base.presenter.BasePresenter
import com.solin.base.presenter.view.BaseView

open class BaseMvpActivity<T: BasePresenter<*>>: BaseActivity(),BaseView{
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    lateinit var mPresenter: T
}