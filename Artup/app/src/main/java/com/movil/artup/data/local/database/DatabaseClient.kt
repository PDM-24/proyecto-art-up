package com.movil.artup.data.local.database

import android.content.Context
import androidx.room.Room

class DatabaseClient private constructor(context: Context) {

    private val appDatabase: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "ArtUpDB"
    ).build()

    fun getAppDatabase(): AppDatabase {
        return appDatabase
    }

    companion object {
        @Volatile
        private var instance: DatabaseClient? = null

        fun getInstance(context: Context): DatabaseClient {
            return instance ?: synchronized(this) {
                instance ?: DatabaseClient(context).also { instance = it }
            }
        }
    }
}
