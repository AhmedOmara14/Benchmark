package com.omaradev.benchmark.example_micro.data.repository

import com.omaradev.benchmark.example_micro.data.remote.PostApi
import com.omaradev.benchmark.example_micro.data.remote.mapper.toDomain
import com.omaradev.benchmark.example_micro.domain.model.Post
import com.omaradev.benchmark.example_micro.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: PostApi) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }
}
