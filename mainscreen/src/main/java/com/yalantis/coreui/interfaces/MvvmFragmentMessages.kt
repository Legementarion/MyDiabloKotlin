package com.yalantis.coreui.interfaces

interface MvvmFragmentMessages {

    fun showSnackbar(message: String)

    fun dialogChangeMessage(message: String)

    fun showProgressDialog()

    fun dismissProgressDialog()

}