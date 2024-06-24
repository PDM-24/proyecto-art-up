package com.movil.artup.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "username") val username: String,
        @ColumnInfo(name = "email") val email: String,
        // otros campos relevantes
    )

