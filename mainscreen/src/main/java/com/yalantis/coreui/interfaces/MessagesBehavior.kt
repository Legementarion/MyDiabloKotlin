package com.yalantis.coreui.interfaces

import androidx.annotation.StringRes

interface MessagesBehavior {

    fun showError(@StringRes strResId: Int)

    fun showError(error: CharSequence?)

    fun showMessage(@StringRes strResId: Int)

    fun showMessage(message: CharSequence?)

}