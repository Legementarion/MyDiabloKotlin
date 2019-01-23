package com.yalantis.coreui.flow.search

import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.*
import org.koin.android.viewmodel.ext.android.viewModel

class HeroListFragment : BaseMvvmFragment<FragmentHeroListBinding, HeroListViewModel>(R.layout.fragment_hero_list) {

    override val viewModel: HeroListViewModel by viewModel()

}