package com.yalantis.coreui.flow.search

import android.databinding.Observable
import android.os.Bundle
import android.view.View
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BaseMvvmFragment
import com.yalantis.coreui.databinding.*
import org.koin.android.viewmodel.ext.android.viewModel

class HeroListFragment : BaseMvvmFragment<FragmentHeroListBinding, HeroListViewModel>(R.layout.fragment_hero_list) {

    override val viewModel: HeroListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isEmpty.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {

            }
        })
    }
}