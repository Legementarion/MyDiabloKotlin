package com.lego.mydiablo.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.lego.mydiablo.repository.models.HeroModel

@Database(entities = arrayOf(HeroModel::class), version = 1, exportSchema = false)
abstract class HeroDataBase: RoomDatabase() {

    private val DB_NAME = "heroDatabase.db"

}