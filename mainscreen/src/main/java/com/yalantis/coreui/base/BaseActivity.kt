package com.yalantis.coreui.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleRegistry
import com.yalantis.coreui.interfaces.MessagesBehavior
import com.yalantis.coreui.utils.SnackbarBehaviorImpl

/**
 * @BaseActivity provides Lifecycle instance to manage it's state in order to introduce quite an easy
 * way to release memory when specific lifecycle event happens.
 */
abstract class BaseActivity<BINDING : ViewDataBinding>(@LayoutRes
                                                       private val layoutResourceId: Int,
                                                       private val snackbarBehavior: SnackbarBehaviorImpl = SnackbarBehaviorImpl())
    : AppCompatActivity(), MessagesBehavior by snackbarBehavior {

    private val registry: LifecycleRegistry
        get() = LifecycleRegistry(this)

    private var rootView: View? = null
    private var _toolbar: Toolbar? = null

    protected lateinit var binding: BINDING
    protected abstract val toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutResourceId != 0) {
            setupBinding()
        }
        snackbarBehavior.init(this, rootView)
        setupToolbar()
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        rootView = binding.root
        _toolbar = toolbar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        if (_toolbar != null) {
            setSupportActionBar(_toolbar)
        }
    }

}