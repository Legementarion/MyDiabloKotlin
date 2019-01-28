package com.yalantis.coreui.flow.search

import android.os.Bundle
import android.view.View
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.FragmentHeroListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SearchHeroFragment : BaseMvvmFragment<FragmentHeroListBinding, SearchHeroViewModel>(R.layout.fragment_hero_list) {

    companion object {
        fun getNewInstance(): SearchHeroFragment {
            return SearchHeroFragment()
        }
    }

    override val viewModel: SearchHeroViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}