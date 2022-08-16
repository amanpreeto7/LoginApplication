package com.o7services.loginapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {
    @Insert
    fun insertNotes(vararg notes:Notes)

    @Query("SELECT * FROM notes")
    fun getAll(): List<Notes>
}