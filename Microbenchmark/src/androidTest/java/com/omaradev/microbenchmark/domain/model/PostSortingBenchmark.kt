package com.omaradev.microbenchmark.domain.model

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import com.omaradev.domain.model.Post
import org.junit.Rule
import org.junit.Test

class PostSortingBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun sortPostsBenchmark() {
        val posts = List(10_000) { Post(it, "Title $it", "Content $it") }.shuffled()

        benchmarkRule.measureRepeated {
            val sorted = posts.sortedBy { it.title }
            if (sorted.firstOrNull()?.id == -1) error("never happens")
        }
    }
}
