package com.yalantis.repository.local.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "heroes")
class HeroModel(@PrimaryKey
                @ColumnInfo(name = "id")
                var id: String = "")
