package com.omaradev.test_benchmark

import android.text.Layout
import androidx.benchmark.macro.ExperimentalMetricApi
import androidx.benchmark.macro.TraceSectionMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.compose.ui.graphics.Path
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TraceSectionBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @OptIn(ExperimentalMetricApi::class)
    @Test
    fun traceBadProductListSection() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(TraceSectionMetric("BadProductListTrace")),
        iterations = 5
    ) {
        pressHome()
        startActivityAndWait()

        val badButton = device.findObject(By.text("Bad Example"))
        badButton.click()

        device.wait(Until.hasObject(By.text("Product #0")), 5_000)

        val list = device.findObject(By.scrollable(true))
        list.scroll(Direction.DOWN,10.0f)
    }

    @OptIn(ExperimentalMetricApi::class)
    @Test
    fun traceGoodProductListSection() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(TraceSectionMetric("GoodProductListTrace")),
        iterations = 5
    ) {
        pressHome()
        startActivityAndWait()

        val goodButton = device.findObject(By.text("Good Example"))
        goodButton.click()

        device.wait(Until.hasObject(By.text("Product #0")), 5_000)

        val list = device.findObject(By.scrollable(true))
        list.scroll(Direction.DOWN,10.0f)
    }
}
