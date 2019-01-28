package com.yalantis.coreui.flow

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmActivity
import com.yalantis.coreui.databinding.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel
        get() = MainViewModel()
    override val toolbar: Toolbar
        get() = binding.toolbar

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_favorite -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_top -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_search -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
