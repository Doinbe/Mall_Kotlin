package com.solin.user.ui.activity

import android.os.Bundle
import com.solin.base.ui.activity.BaseMvpActivity
import com.solin.user.R
import com.solin.user.injection.component.DaggerUserComponent
import com.solin.user.injection.module.UserModule
import com.solin.user.presenter.RegisterPresenter
import com.solin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView{
    override fun initInjecComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build().inject(this)
        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener {
//            startActivity<TestActivity>("Test" to "测试页面")
            mPresenter.register(edtMobile.text.toString(),edtPwd.text.toString(),edtCode.text.toString())
        }

        btnCode.setOnClickListener {
            toast("获取验证码")
        }

    }

}
