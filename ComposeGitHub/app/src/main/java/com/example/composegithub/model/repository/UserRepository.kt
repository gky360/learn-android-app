package com.example.composegithub.model.repository

interface UserRepository {
    suspend fun getUser(userName: String): User
}
