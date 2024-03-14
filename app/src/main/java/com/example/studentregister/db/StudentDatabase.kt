package com.example.studentregister.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun StudentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE : StudentDatabase? = null
        fun getInstance(context: Context):StudentDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "stuent_data_database"
                    ).build()
                }
                return instance
            }

        }
    }


}