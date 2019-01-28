package com.yalantis.repository.di

import android.arch.persistence.room.Room
import com.yalantis.core.datasources.LocalHeroesDataSource
import com.yalantis.core.repositories.HeroesRepository
import com.yalantis.network.di.remoteModule
import com.yalantis.repository.HeroesRepositoryImpl
import com.yalantis.repository.local.LocalDataSourceImpl
import com.yalantis.repository.local.database.HeroDataBase
import com.yalantis.repository.local.database.HeroDataBase.Companion.DB_NAME
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val repositoryModule: List<Module>
    get() = listOf(localModule, remoteModule)


val localModule = module {
    single<HeroesRepository> { HeroesRepositoryImpl(get(), get()) }
    single<LocalHeroesDataSource> { LocalDataSourceImpl(get()) }
    single { Room.databaseBuilder(get("context"), HeroDataBase::class.java, DB_NAME).build().heroesDao()}
}