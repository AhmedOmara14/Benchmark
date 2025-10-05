package com.omaradev.benchmark.example_micro.data.remote

import com.omaradev.benchmark.example_micro.data.remote.dto.PostDto
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
