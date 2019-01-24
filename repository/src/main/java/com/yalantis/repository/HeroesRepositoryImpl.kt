package com.yalantis.repository

import com.yalantis.core.datasources.LocalHeroesDataSource
import com.yalantis.core.datasources.RemoteHeroesDataSource
import com.yalantis.core.repositories.HeroesRepository

class HeroesRepositoryImpl(private val localHeroesDataSource: LocalHeroesDataSource,
                           private val remoteHeroesDataSource: RemoteHeroesDataSource) : HeroesRepository {

    override fun findTopHeroesBySpec() {
        remoteHeroesDataSource.findTopHeroesBySpec()
    }

    override fun searchByName(query: String) {
        remoteHeroesDataSource.searchByName(query)
    }

    override fun addToFavorite(id: String) {
        localHeroesDataSource.addToFavorite(id)
    }
}