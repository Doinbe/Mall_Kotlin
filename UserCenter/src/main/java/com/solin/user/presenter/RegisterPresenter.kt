package com.solin.user.presenter

import com.solin.base.ext.execute
import com.solin.base.presenter.BasePresenter
import com.solin.base.rx.BaseSubscriber
import com.solin.user.presenter.view.RegisterView
import com.solin.user.service.impl.UserServiceImpl

class RegisterPresenter: BasePresenter<RegisterView>() {

    fun register(name: String,pwd: String){
        val userService = UserServiceImpl()
        mView.showLoading()
        userService.register(name,pwd)
                .execute(object :BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        mView.onRegisterResult(t)
                    }
                })

    }
}