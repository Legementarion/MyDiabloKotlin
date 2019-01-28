package com.yalantis.network.di

import com.yalantis.core.datasources.RemoteHeroesDataSource
import com.yalantis.network.RemoteDataSourceImpl
import org.koin.dsl.module.module

val remoteModule = module {
    single<RemoteHeroesDataSource> { RemoteDataSourceImpl(getProperty("blizzard_url")) }
}
