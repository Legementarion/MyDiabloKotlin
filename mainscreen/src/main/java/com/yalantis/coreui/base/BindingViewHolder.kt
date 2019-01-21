package com.yalantis.coreui.base

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * Common functionality needed when you are creating ViewHolders
 */
abstract class BindingViewHolder<in T, in VIEW_MODEL>(override val containerView: View)
    : RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(item: T, viewModel: VIEW_MODEL)

    protected fun getString(@StringRes resId: Int): String? = containerView.context.getString(resId)

    protected fun <T : View> findView(@IdRes resId: Int): T? = containerView.findViewById<T?>(resId)

    protected val context: Context get() = containerView.context

}