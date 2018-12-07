package com.solin.base.ui.activity

import android.os.Bundle
import com.solin.base.comom.BaseApplication
import com.solin.base.injection.component.ActivityComponent
import com.solin.base.injection.component.DaggerActivityComponent
import com.solin.base.injection.module.ActivityModule
import com.solin.base.injection.module.LifecycleProviderModule
import com.solin.base.presenter.BasePresenter
import com.solin.base.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject

open class BaseMvpActivity<T: BasePresenter<*>>: BaseActivity(),BaseView{
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(error: String) {
        toast(error)
    }
    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

}