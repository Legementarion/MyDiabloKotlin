package com.lego.mydiablo.di

import com.yalantis.coreui.di.*
import com.yalantis.repository.di.repositoryModule
import org.koin.dsl.module.Module

val appModule: List<Module>
    get() = listOf(toolsModule,
            heroTopModule,
            heroDetailModule,
            heroListModule,
            navigationModule,
            favoriteModule) + repositoryModule

