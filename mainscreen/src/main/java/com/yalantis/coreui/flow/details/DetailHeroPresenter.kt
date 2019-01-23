package com.yalantis.coreui.flow.details

import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.FragmentHeroDetailsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailHeroPresenter  : BaseMvvmFragment<FragmentHeroDetailsBinding, HeroDetailViewModel>(R.layout.fragment_hero_details) {

    override val viewModel: HeroDetailViewModel by viewModel()

}