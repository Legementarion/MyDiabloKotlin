package com.yalantis.coreui.base

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @BaseViewModel cares about disposing disposables and has fields to manage:
 * -error messages showing
 * -showing progress
 * -change progress dialog message
 */
abstract class BaseViewModel : ViewModel() {

    val showGenericMessage = ObservableField("")
    val showProgressDialog = ObservableField(false)
    val progressMessage = ObservableField("")
    val showKeyboard = ObservableBoolean()

}