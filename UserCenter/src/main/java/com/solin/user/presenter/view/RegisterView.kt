package com.solin.user.presenter.view

import com.solin.base.presenter.view.BaseView

interface RegisterView: BaseView {
    fun onRegisterResult(result: Boolean)
}