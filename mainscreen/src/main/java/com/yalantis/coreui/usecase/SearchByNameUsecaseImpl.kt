package com.yalantis.coreui.usecase

import com.yalantis.core.repositories.HeroesRepository
import com.yalantis.core.usecases.SearchByNameUsecase

class SearchByNameUsecaseImpl(private val heroesRepository: HeroesRepository) : SearchByNameUsecase {
    override fun searchByName(query: String) {
        heroesRepository.searchByName(query)
    }
}