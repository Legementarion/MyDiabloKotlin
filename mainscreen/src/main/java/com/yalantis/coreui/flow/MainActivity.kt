package com.yalantis.coreui.flow

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmActivity
import com.yalantis.coreui.databinding.ActivityMainBinding
import com.yalantis.coreui.flow.favorite.FavoriteFragment
import com.yalantis.coreui.flow.search.SearchHeroFragment
import com.yalantis.coreui.flow.top.HeroTopFragment
import com.yalantis.coreui.interfaces.BackButtonListener
import com.yalantis.coreui.navigation.MainRouter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.pure.AppNavigator
import ru.terrakok.cicerone.commands.Command

class MainActivity : BaseMvvmActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel
        get() = MainViewModel()
    override val toolbar: Toolbar
        get() = binding.toolbar
    private val router: MainRouter by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private lateinit var tabsAdapter: TabPagerAdapter

    private val navigator = object : AppNavigator(this, com.yalantis.coreui.R.id.tabContainer) {
        override fun applyCommands(commands: Array<Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_favorite -> {
                tabContainer.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_top -> {
                tabContainer.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_search -> {
                tabContainer.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabsAdapter = TabPagerAdapter()
        tabContainer.adapter = tabsAdapter
        tabContainer.currentItem = 0
        tabContainer.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                bottomNavigation.menu.getItem(position).isChecked = true
            }

            override fun onPageSelected(position: Int) {
            }
        })
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        router.showStartScreen()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.tabContainer)
        if (fragment != null
                && fragment is BackButtonListener
                && (fragment as BackButtonListener).onBackPressed()) {
            return
        } else {
            super.onBackPressed()
        }
    }

    inner class TabPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {

        private val fragments = listOf<Fragment>(
                FavoriteFragment.getNewInstance(),
                HeroTopFragment.getNewInstance(),
                SearchHeroFragment.getNewInstance()
        )

        private val tabTitles = listOf(
                getString(R.string.favorite),
                getString(R.string.top),
                getString(R.string.search)
        )

        override fun getItem(position: Int) = fragments[position]
        override fun getCount() = fragments.size
        override fun getPageTitle(position: Int): String = tabTitles[position]
    }
}
