package com.yalantis.coreui.flow.favorite

import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.FragmentFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment: BaseMvvmFragment<FragmentFavoriteBinding, FavoriteViewModel>(R.layout.fragment_favorite) {

    override val viewModel: FavoriteViewModel by viewModel()

}