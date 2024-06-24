package com.movil.artup.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.movil.artup.data.local.database.DatabaseClient
import com.movil.artup.data.local.database.entity.User
import com.movil.artup.data.local.repository.UserRepository
import com.movil.artup.data.remoto.api.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        val userDao = DatabaseClient.getInstance(application).getAppDatabase().userDao()
        val apiService = RetrofitClient.instance
        repository = UserRepository(userDao, apiService)
        allUsers = liveData {
            val users = repository.getUsers()
            emit(users)
        }
    }

    fun createUser(user: User) {
        viewModelScope.launch {
            repository.createUser(user)
        }
    }
}
