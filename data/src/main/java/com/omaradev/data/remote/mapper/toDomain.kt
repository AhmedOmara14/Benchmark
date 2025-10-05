package com.omaradev.data.remote.mapper

import com.omaradev.data.remote.dto.PostDto
import com.omaradev.domain.model.Post


fun PostDto.toDomain() = Post(
    id = id,
    title = title,
    body = body
)