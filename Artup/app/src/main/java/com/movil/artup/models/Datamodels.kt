package com.movil.artup.models

data class User(
    val username: String,
    val password: String
)

data class Credentials(
    val email: String,
    val password: String
)

data class Post(
    val username: String,
    val image: String,
    val price: Double,
    val description: String,
    val isForSale: Boolean
)

data class Event(
    val institutionName: String,
    val eventDate: String,
    val description: String
)
