package com.omaradev.benchmark.example_micro.domain.repository

import com.omaradev.benchmark.example_micro.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}
