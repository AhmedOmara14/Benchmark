package com.omaradev.domain.repository

import com.omaradev.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}
