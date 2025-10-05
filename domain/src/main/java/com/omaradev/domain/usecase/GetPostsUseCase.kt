package com.omaradev.domain.usecase

import com.omaradev.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke() = repository.getPosts()
}
