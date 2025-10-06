package com.omaradev.microbenchmark.data.repository

import com.omaradev.domain.model.Post
import com.omaradev.domain.repository.PostRepository

val fakeRepository = object : PostRepository {
        override suspend fun getPosts(): List<Post> {
            return List(1000) { Post(it, "Title $it", "Body $it") }
        }
    }