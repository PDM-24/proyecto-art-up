package com.movil.artup.data.remoto.api

import retrofit2.Response
import com.movil.artup.data.local.database.entity.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun createUser(@Body user: User): Response<User>
}
