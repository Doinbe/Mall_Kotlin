package com.solin.user.presenter

import com.solin.base.ext.execute
import com.solin.base.ext.getRequestBody
import com.solin.base.presenter.BasePresenter
import com.solin.base.rx.BaseException
import com.solin.base.rx.BaseSubscriber
import com.solin.user.data.procotol.RegisterReq
import com.solin.user.presenter.view.RegisterView
import com.solin.user.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String,pwd: String,verifyCode: String){
        mView.showLoading()

        userService.register(RegisterReq(mobile,pwd,verifyCode).getRequestBody())
                .execute(object :BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        mView.onRegisterResult(t)
                    }

                    override fun onError(e: Throwable?) {
                        super.onError(e)
                        if (e is BaseException) mView.onError(e.msg)
                    }
                })

    }
}