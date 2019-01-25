package com.yalantis.repository.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yalantis.repository.local.models.HeroDAO
import com.yalantis.repository.local.models.HeroModel

@Database(entities = [HeroModel::class], version = 1, exportSchema = false)
abstract class HeroDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "heroDatabase.db"
    }

    abstract fun heroesDao(): HeroDAO

}