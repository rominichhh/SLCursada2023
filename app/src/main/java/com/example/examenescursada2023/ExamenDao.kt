package com.example.examenescursada2023

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ExamenDao {
    @Query("select * from examenes_table")
    fun getAll(): List<Examen>

    @Insert
    fun insertExamen(examen: Examen)
}