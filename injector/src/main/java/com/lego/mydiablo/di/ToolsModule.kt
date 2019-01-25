package com.lego.mydiablo.di

import com.lego.mydiablo.DiabloApplication
import org.koin.dsl.module.module

val toolsModule = module {
    single { DiabloApplication.applicationContext() }
}