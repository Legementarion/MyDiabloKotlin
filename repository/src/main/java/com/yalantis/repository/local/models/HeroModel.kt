package com.yalantis.repository.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
class HeroModel(@PrimaryKey
                @ColumnInfo(name = "id")
                var id: String = "")
