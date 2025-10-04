package com.omaradev.benchmark.example_micro.domain.usecase

import com.omaradev.benchmark.example_micro.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke() = repository.getPosts()
}
