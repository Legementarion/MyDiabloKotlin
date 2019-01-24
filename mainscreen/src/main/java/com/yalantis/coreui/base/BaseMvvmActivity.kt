package com.yalantis.coreui.base

import android.app.ProgressDialog
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.yalantis.coreui.interfaces.MvvmFragmentMessages
import com.yalantis.coreui.utils.onPropertyChanged

/**
 * @BaseMvvmActivity actually stands for showing messages and progress, also holds ViewModel reference.
 */
abstract class BaseMvvmActivity<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel>(layoutResourceId: Int) :
        BaseActivity<BINDING>(layoutResourceId), MvvmFragmentMessages {

    protected abstract val viewModel: VIEW_MODEL

    private var progressDialog: ProgressDialog? = null
    private var genericMessageCallback: Observable.OnPropertyChangedCallback? = null
    private var progressDialogCallback: Observable.OnPropertyChangedCallback? = null
    private var progressMessageCallback: Observable.OnPropertyChangedCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
        progressDialog?.setCancelable(false)

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

    override fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun dialogChangeMessage(message: String) {
        progressDialog?.setMessage(message)
    }

    override fun showProgressDialog() {
        progressDialog?.show()
    }

    override fun dismissProgressDialog() {
        if (progressDialog != null && progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
        }
    }

    override fun onDestroy() {
        genericMessageCallback?.let { viewModel.showGenericMessage.removeOnPropertyChangedCallback(it) }
        progressDialogCallback?.let { viewModel.showProgressDialog.removeOnPropertyChangedCallback(it) }
        progressMessageCallback?.let { viewModel.progressMessage.removeOnPropertyChangedCallback(it) }
        super.onDestroy()
    }
}