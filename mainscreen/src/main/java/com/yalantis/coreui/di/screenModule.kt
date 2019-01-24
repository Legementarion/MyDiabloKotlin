package com.yalantis.coreui.di

import com.yalantis.coreui.flow.details.HeroDetailViewModel
import com.yalantis.coreui.flow.favorite.FavoriteViewModel
import com.yalantis.coreui.flow.search.HeroListViewModel
import com.yalantis.coreui.flow.top.HeroTopViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val favoriteModule = module {
    viewModel { FavoriteViewModel() }
}

val heroListModule = module {
    viewModel { HeroListViewModel(get()) }
}

val heroDetailModule = module {
    viewModel { HeroDetailViewModel() }
}

val heroTopModule = module {
    viewModel { HeroTopViewModel() }
}