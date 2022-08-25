package com.o7services.loginapplication.room

import androidx.room.*

@Dao
interface NotesDao {
    @Insert
    fun insertNotes(vararg notes:Notes)

    @Query("SELECT * FROM notes")
    fun getAll(): List<Notes>

    @Delete
    fun deleteNotes(vararg notes: Notes)

    @Update
    fun updateNotes(vararg notes:Notes)
}