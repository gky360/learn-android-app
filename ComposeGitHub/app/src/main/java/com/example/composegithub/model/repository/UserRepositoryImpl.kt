package com.example.composegithub.model.repository

import com.example.composegithub.model.remote_data_source.GitHubUser
import com.example.composegithub.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val remoteDataStore: RemoteDataSource) :
    UserRepository {
    override suspend fun getUser(userName: String): User {
        return remoteDataStore.getGitHubUser(userName = userName).toUser()
    }
}

private fun GitHubUser.toUser(): User {
    return User(
        userId = UserId(value = id),
        name = name,
        avatarImage = NetworkImage(url = Url(value = avatarUrl)),
        blogUrl = Url(value = blog)
    )
}
