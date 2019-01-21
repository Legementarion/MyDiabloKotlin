package com.yalantis.coreui.base

import android.app.ProgressDialog
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
        progressDialog?.setCancelable(false)

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

}