package com.solin.user.ui.activity

import android.os.Bundle
import com.solin.base.ui.activity.BaseMvpActivity
import com.solin.user.R
import com.solin.user.presenter.RegisterPresenter
import com.solin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView{
    override fun onRegisterResult(isOk: Boolean) {
        if (isOk) toast("注册成功") else toast("注册失败")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        btnRegister.setOnClickListener {
//            startActivity<TestActivity>("Test" to "测试页面")

            mPresenter.register("luckLyMan","123456")
        }

        btnCode.setOnClickListener {
            toast("获取验证码")
        }

    }

}
