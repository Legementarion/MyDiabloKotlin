package com.lego.mydiablo.di

import org.koin.dsl.module.Module

val appModule: List<Module>
    get() = listOf(toolsModule)