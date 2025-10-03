package com.omaradev.test_benchmark

import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StartupBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()


    @Test
    fun startupCold() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
    }


    @Test
    fun startupWarm() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.WARM
    ) {
        pressHome()
        startActivityAndWait()
    }

    @Test
    fun startupHot() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.HOT
    ) {
        pressHome()
        startActivityAndWait()
    }
}