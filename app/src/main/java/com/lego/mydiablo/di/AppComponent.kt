package com.lego.mydiablo.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MenuModule::class, HeroListModule::class, DetailHeroModule::class))
interface AppComponent {
}