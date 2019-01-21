package com.yalantis.coreui.base

import android.content.Context
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
        // todo disposable handle it

        viewModel.showGenericMessage.onPropertyChanged(showGenericMessage)

        viewModel.showProgressDialog.onPropertyChanged {
            val show = it.get()
            when (show) {
                true -> showProgressDialog()
                false -> dismissProgressDialog()
            }
        }
        viewModel.progressMessage.onPropertyChanged {
            val messageId = it.get()
            if (messageId?.isNotEmpty() == true) {
                dialogChangeMessage(messageId)
            }
        }
    }

    private val showGenericMessage: (ObservableField<String>) -> Unit = {
        val message = it.get()
        if (message?.isNotEmpty() == true) {
            showSnackbar(message)
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