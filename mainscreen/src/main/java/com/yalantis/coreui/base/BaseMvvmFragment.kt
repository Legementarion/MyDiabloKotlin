package com.yalantis.coreui.base

import android.content.Context
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.yalantis.coreui.interfaces.MvvmFragmentMessages
import com.yalantis.coreui.utils.onPropertyChanged

/**
 * @BaseMvvmFragment actually stands for showing messages and progress, also holds ViewModel reference.
 */
abstract class BaseMvvmFragment<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel>(layoutResourceId: Int,
                                                                                       protected val viewModel: VIEW_MODEL) :
        BaseFragment<BINDING>(layoutResourceId) {

    private lateinit var messageInterface: MvvmFragmentMessages
    private var genericMessageCallback: Observable.OnPropertyChangedCallback? = null
    private var progressDialogCallback: Observable.OnPropertyChangedCallback? = null
    private var progressMessageCallback: Observable.OnPropertyChangedCallback? = null

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

    private fun setupGenericErrorListener() {

        genericMessageCallback = viewModel.showGenericMessage.onPropertyChanged(showGenericMessage)

        progressDialogCallback = viewModel.showProgressDialog.onPropertyChanged(showProgressDialog)

        progressMessageCallback = viewModel.progressMessage.onPropertyChanged(progressMessage)
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