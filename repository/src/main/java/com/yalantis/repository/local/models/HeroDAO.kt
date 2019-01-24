package com.yalantis.repository.local.models

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface HeroDAO {

    @Query("select * from heroes")
    fun getAllHero(): List<HeroModel>

    @Query("select * from heroes where id = :p0")
    fun findHeroById(id: Long): HeroModel

    @Insert(onConflict = REPLACE)
    fun insertHero(task: HeroModel)

    @Update(onConflict = REPLACE)
    fun updateHero(task: HeroModel)

    @Delete
    fun deleteHero(task: HeroModel)

}