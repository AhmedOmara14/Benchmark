package com.omaradev.microbenchmark.data.repository

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class RepositoryOperationBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun repositoryFetchPosts() = runBlocking {
        benchmarkRule.measureRepeated {
            runBlocking {
                fakeRepository.getPosts()
            }
        }
    }
}