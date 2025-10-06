package com.omaradev.microbenchmark.usecase

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import com.omaradev.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class GetPostsUseCaseBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun invokeBenchmark() {
        val useCase = GetPostsUseCase(fakeRepository)

        benchmarkRule.measureRepeated {
            runBlocking { useCase.invoke() }
        }
    }
}