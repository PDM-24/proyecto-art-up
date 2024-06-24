package com.movil.artup.data.local.repository

import com.movil.artup.data.local.database.dao.UserDao
import com.movil.artup.data.local.database.entity.User
import com.movil.artup.data.remoto.api.ApiService

class UserRepository(private val userDao: UserDao, private val apiService: ApiService) {

    suspend fun getUsers(): List<User> {
        return try {
            val response = apiService.getUsers()
            // Guarda los usuarios en la base de datos local
            for (user in response) {
                userDao.insert(user)
            }
            response
        } catch (e: Exception) {
            // Si la API falla, recupera los datos locales
            userDao.getAllUsers()
        }
    }

    suspend fun createUser(user: User): User {
        return try {
            val response = apiService.createUser(user)
            if (response.isSuccessful) {
                // Guarda el usuario en la base de datos local
                userDao.insert(response.body()!!)
            }
            response.body()!!
        } catch (e: Exception) {
            userDao.insert(user)
            user
        }
    }
}
