package com.omaradev.benchmark.example_micro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omaradev.benchmark.example_micro.domain.model.Post
import com.omaradev.benchmark.example_micro.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    fun loadPosts() {
        viewModelScope.launch {
            _posts.value = getPostsUseCase()
        }
    }
}
