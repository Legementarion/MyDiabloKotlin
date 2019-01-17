package com.yalantis.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.yalantis.core.models.models.HeroModel

@Database(entities = [HeroModel::class], version = 1, exportSchema = false)
abstract class HeroDataBase: RoomDatabase() {

    private val DB_NAME = "heroDatabase.db"

}