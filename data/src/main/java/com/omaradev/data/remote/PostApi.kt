package com.omaradev.data.remote

import com.omaradev.data.remote.dto.PostDto
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
