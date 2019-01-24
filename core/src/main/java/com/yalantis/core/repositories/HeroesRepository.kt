package com.yalantis.core.repositories

interface HeroesRepository {
    fun findTopHeroesBySpec()
    fun searchByName(query:String)
    fun addToFavorite(id: String)
}