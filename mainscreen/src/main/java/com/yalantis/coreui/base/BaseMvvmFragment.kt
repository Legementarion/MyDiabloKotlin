package com.yalantis.coreui.base

import android.content.Context
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.yalantis.coreui.interfaces.MvvmFragmentMessages
import com.yalantis.coreui.utils.hideKeyboard
import com.yalantis.coreui.utils.onPropertyChanged

/**
 * @BaseMvvmFragment actually stands for showing messages and progress, also holds ViewModel reference.
 */
abstract class BaseMvvmFragment<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel>(layoutResourceId: Int) :
        BaseFragment<BINDING>(layoutResourceId) {

    protected abstract val viewModel: VIEW_MODEL

    private lateinit var messageInterface: MvvmFragmentMessages
    private var genericMessageCallback: Observable.OnPropertyChangedCallback? = null
    private var progressDialogCallback: Observable.OnPropertyChangedCallback? = null
    private var progressMessageCallback: Observable.OnPropertyChangedCallback? = null
    private var showKeyboardCallback: Observable.OnPropertyChangedCallback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MvvmFragmentMessages) {
            messageInterface = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGenericErrorListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        genericMessageCallback?.let { viewModel.showGenericMessage.removeOnPropertyChangedCallback(it) }
        progressDialogCallback?.let { viewModel.showProgressDialog.removeOnPropertyChangedCallback(it) }
        progressMessageCallback?.let { viewModel.progressMessage.removeOnPropertyChangedCallback(it) }
        showKeyboardCallback?.let { viewModel.showKeyboard.removeOnPropertyChangedCallback(it) }
    }

    private fun setupGenericErrorListener() {
        genericMessageCallback = viewModel.showGenericMessage.onPropertyChanged(showGenericMessage)
        progressDialogCallback = viewModel.showProgressDialog.onPropertyChanged(showProgressDialog)
        progressMessageCallback = viewModel.progressMessage.onPropertyChanged(progressMessage)
        showKeyboardCallback = viewModel.showKeyboard.onPropertyChanged(showKeyboardDialog)
    }

    private val showGenericMessage: (ObservableField<String>) -> Unit = {
        val message = it.get()
        if (message?.isNotEmpty() == true) {
            showSnackbar(message)
        }
    }

    private val showProgressDialog: (ObservableField<Boolean>) -> Unit = {
        val show = it.get()
        when (show) {
            true -> showProgressDialog()
            false -> dismissProgressDialog()
        }
    }

    private val showKeyboardDialog: (ObservableBoolean) -> Unit = {
        val show = it.get()
        when (show) {
            false -> hideKeyboard()
        }
    }

    private val progressMessage: (ObservableField<String>) -> Unit = {
        val messageId = it.get()
        if (messageId?.isNotEmpty() == true) {
            dialogChangeMessage(messageId)
        }
    }

    private fun showSnackbar(message: String) {
        messageInterface.showSnackbar(message)
    }

    private fun dialogChangeMessage(message: String) {
        messageInterface.dialogChangeMessage(message)
    }

    private fun showProgressDialog() {
        messageInterface.showProgressDialog()
    }

    private fun dismissProgressDialog() {
        messageInterface.dismissProgressDialog()
    }

}