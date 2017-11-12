package com.lego.mydiablo.repository.database

import android.arch.persistence.room.RoomDatabase

abstract class HeroDataBase: RoomDatabase() {

    private val DB_NAME = "heroDatabase.db"

}