package com.lego.mydiablo.di

import com.yalantis.coreui.di.favoriteModule
import com.yalantis.coreui.di.heroDetailModule
import com.yalantis.coreui.di.heroListModule
import org.koin.dsl.module.Module

val appModule: List<Module>
    get() = listOf(toolsModule,
            heroDetailModule,
            heroListModule,
            favoriteModule)