package com.yalantis.coreui.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    val view = currentFocus
    if (view != null) {
        val token = view.windowToken
        if (inputManager != null && token != null) {
            inputManager.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Fragment.getFragmentTag(suffix: String = "") = this::class.java.simpleName + suffix

fun AppCompatDialogFragment.show(manager: FragmentManager) {
    show(manager, getFragmentTag())
}

inline fun <reified T : Observable> T.onPropertyChanged(crossinline callback: (T) -> Unit): Observable.OnPropertyChangedCallback =

        object : Observable.OnPropertyChangedCallback() {

            override fun onPropertyChanged(observable: Observable?, i: Int) {
                callback(observable as T)
            }
        }
                .also {
                    addOnPropertyChangedCallback(it)
                }