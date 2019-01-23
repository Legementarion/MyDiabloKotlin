package com.yalantis.coreui.flow.top

import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.*
import org.koin.android.viewmodel.ext.android.viewModel

class HeroTopfragment: BaseMvvmFragment<FragmentHeroTopBinding, HeroTopViewModel>(R.layout.fragment_hero_top) {

    override val viewModel: HeroTopViewModel by viewModel()

}