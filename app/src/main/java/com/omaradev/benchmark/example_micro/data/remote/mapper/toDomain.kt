package com.omaradev.benchmark.example_micro.data.remote.mapper

import com.omaradev.benchmark.example_micro.data.remote.dto.PostDto
import com.omaradev.benchmark.example_micro.domain.model.Post


fun PostDto.toDomain() = Post(
    id = id,
    title = title,
    body = body
)