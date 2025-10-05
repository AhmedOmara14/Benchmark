package com.omaradev.data.repository

import com.omaradev.data.remote.PostApi
import com.omaradev.data.remote.mapper.toDomain
import com.omaradev.domain.model.Post
import com.omaradev.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: PostApi) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }
}
