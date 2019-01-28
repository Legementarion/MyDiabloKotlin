package com.yalantis.coreui.flow.top

import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.*
import com.yalantis.coreui.flow.favorite.FavoriteFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HeroTopFragment: BaseMvvmFragment<FragmentHeroTopBinding, HeroTopViewModel>(R.layout.fragment_hero_top) {

    companion object {
        fun getNewInstance(): HeroTopFragment {
            return HeroTopFragment()
        }
    }

    override val viewModel: HeroTopViewModel by viewModel()

}