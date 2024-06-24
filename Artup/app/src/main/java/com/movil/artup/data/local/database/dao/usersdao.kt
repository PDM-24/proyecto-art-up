package com.movil.artup.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movil.artup.data.local.database.entity.User
@Dao
    interface UserDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(user: User)

        @Query("SELECT * FROM users WHERE id = :id")
        suspend fun getUserById(id: Int): User

        @Query("SELECT * FROM users")
        suspend fun getAllUsers(): List<User>

        @Delete
        suspend fun delete(user: User)
    }
