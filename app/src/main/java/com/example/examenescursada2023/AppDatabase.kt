package com.example.examenescursada2023

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Examen::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun examenDao(): ExamenDao

    companion object{

        private var INSTANCIA: AppDatabase?= null

        fun getDatabase(contexto: Context) : AppDatabase{
            if(INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                    contexto, AppDatabase::class.java, "base_app_examenes")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }



    }

}