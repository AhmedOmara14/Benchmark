package com.omaradev.microbenchmark.data.remote

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import com.omaradev.domain.model.Post
import kotlinx.serialization.json.Json
import org.junit.Rule
import org.junit.Test

class JsonDeserializationBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val jsonParser = Json { ignoreUnknownKeys = true }
    private val json = """
        {"id": 1, "title": "Benchmark", "content": "Testing microbenchmark JSON"}
    """.trimIndent()

    @Test
    fun decodeJsonBenchmark() {
        benchmarkRule.measureRepeated {
            jsonParser.decodeFromString<Post>(json)
        }
    }
}