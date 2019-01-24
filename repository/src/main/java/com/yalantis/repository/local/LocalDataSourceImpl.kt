package com.yalantis.repository.local

import com.yalantis.core.datasources.LocalHeroesDataSource
import com.yalantis.repository.local.models.HeroDAO
import com.yalantis.repository.local.models.HeroModel

class LocalDataSourceImpl(private val heroDAO: HeroDAO): LocalHeroesDataSource {

    override fun addToFavorite(id: String) {
        heroDAO.insertHero(HeroModel()) // todo real model
    }
}