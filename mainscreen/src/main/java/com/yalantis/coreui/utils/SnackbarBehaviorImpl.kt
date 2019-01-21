package com.yalantis.coreui.utils

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import com.yalantis.coreui.interfaces.MessagesBehavior

class SnackbarBehaviorImpl: MessagesBehavior {

    private var context: Context? = null
    private var rootView: View? = null

    fun init(context: Context, rootView: View?) {
        this.context = context
        this.rootView = rootView
    }

    override fun showError(strResId: Int) = showError(context?.getString(strResId))

    override fun showError(error: CharSequence?) = showMessage(error)

    override fun showMessage(strResId: Int) = showMessage(context?.getString(strResId))

    override fun showMessage(message: CharSequence?) {
        rootView?.let { rootView ->
            message?.let { message ->
                Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}