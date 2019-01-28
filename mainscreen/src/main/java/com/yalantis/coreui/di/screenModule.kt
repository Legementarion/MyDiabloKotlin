package com.yalantis.coreui.di

import com.yalantis.core.usecases.SearchByNameUsecase
import com.yalantis.coreui.flow.details.HeroDetailViewModel
import com.yalantis.coreui.flow.favorite.FavoriteViewModel
import com.yalantis.coreui.flow.search.SearchHeroViewModel
import com.yalantis.coreui.flow.top.HeroTopViewModel
import com.yalantis.coreui.navigation.MainRouter
import com.yalantis.coreui.usecase.SearchByNameUsecaseImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val navigationModule = module {
    single { MainRouter(get()) }
    single { Cicerone.create() }
    single { get<Cicerone<ru.terrakok.cicerone.Router>>().navigatorHolder }
    single { get<Cicerone<ru.terrakok.cicerone.Router>>().router as Router }
}
val favoriteModule = module {
    viewModel { FavoriteViewModel() }
}

val heroListModule = module {
    viewModel { SearchHeroViewModel(get()) }
    factory<SearchByNameUsecase> { SearchByNameUsecaseImpl(get()) }
}

val heroDetailModule = module {
    viewModel { HeroDetailViewModel() }
}

val heroTopModule = module {
    viewModel { HeroTopViewModel() }
}