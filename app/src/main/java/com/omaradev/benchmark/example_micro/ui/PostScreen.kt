package com.omaradev.benchmark.example_micro.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {
    val posts by viewModel.posts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    LazyColumn {
        items(posts) { post ->
            Text(text = post.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
    }
}
