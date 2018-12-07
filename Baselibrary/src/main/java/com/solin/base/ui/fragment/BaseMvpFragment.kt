package com.solin.base.ui.fragment

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

abstract class BaseMvpFragment<T: BasePresenter<*>>: BaseFragment(),BaseView{
     override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(error: String) {
        activity?.toast(error)
    }
    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent

    abstract fun initInjecComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        initInjecComponent()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((activity?.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this!!.activity!!))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

}