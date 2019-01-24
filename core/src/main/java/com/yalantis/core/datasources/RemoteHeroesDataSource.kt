package com.yalantis.core.datasources

interface RemoteHeroesDataSource {
    fun findTopHeroesBySpec()
    fun searchByName(query:String)
}