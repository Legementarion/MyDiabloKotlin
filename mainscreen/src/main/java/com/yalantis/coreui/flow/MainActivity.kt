package com.yalantis.coreui.flow

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmActivity
import com.yalantis.coreui.databinding.*

class MainActivity : BaseMvvmActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel
        get() = MainViewModel()
    override val toolbar: Toolbar
        get() = binding.toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
