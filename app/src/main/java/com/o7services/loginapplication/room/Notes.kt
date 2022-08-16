package com.o7services.loginapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Notes {
    @PrimaryKey (autoGenerate = true)
    var id : Int = 0
    @ColumnInfo(name = "title") var title: String?= null
    @ColumnInfo(name = "description") var description: String?= null
    @ColumnInfo(name = "date") var date: String?= null
}