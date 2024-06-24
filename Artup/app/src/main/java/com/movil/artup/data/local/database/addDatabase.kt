package com.movil.artup.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movil.artup.data.local.database.dao.UserDao
import com.movil.artup.data.local.database.entity.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao
}
