package com.omaradev.microbenchmark.usecase

import com.omaradev.domain.model.Post
import com.omaradev.domain.repository.PostRepository

val fakeRepository = object : PostRepository {
        override suspend fun getPosts(): List<Post> {
            return List(1000) { Post(it, "Title $it", "Body $it") }
        }
    }