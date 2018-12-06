package com.solin.base.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(error: String)
}