package com.yalantis.coreui.base

import android.arch.lifecycle.LifecycleRegistry
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yalantis.coreui.interfaces.MessagesBehavior

abstract class BaseFragment<BINDING : ViewDataBinding>(private val layoutResourceId: Int) : Fragment(), MessagesBehavior {

    private val registry: LifecycleRegistry
        get() = LifecycleRegistry(this)

    private var activityMessagesBehavior: MessagesBehavior? = null

    protected lateinit var binding: BINDING

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityMessagesBehavior = context as MessagesBehavior?
        } catch (ignored: ClassCastException) {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return if (layoutResourceId > 0) {
            binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
            binding.root
        } else {
            null
        }
    }

    override fun showError(error: CharSequence?) {
        activityMessagesBehavior?.showError(error)
    }

    override fun showError(@StringRes strResId: Int) {
        activityMessagesBehavior?.showError(strResId)
    }

    override fun showMessage(message: CharSequence?) {
        activityMessagesBehavior?.showMessage(message)
    }

    override fun showMessage(@StringRes strResId: Int) {
        activityMessagesBehavior?.showMessage(strResId)
    }

}