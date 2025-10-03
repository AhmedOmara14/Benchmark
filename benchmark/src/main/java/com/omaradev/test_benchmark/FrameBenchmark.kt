package com.omaradev.test_benchmark

import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FrameBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun scrollBadExample() = benchmarkRule.measureRepeated(
        packageName = "com.omaradev.benchmark",
        metrics = listOf(FrameTimingMetric()),
        iterations = 5
    ) {
        // Launch app
        pressHome()
        startActivityAndWait()

        // Wait until product list is visible
        device.wait(Until.hasObject(By.text("Product #0")), 5_000)

        // Scroll to a product using UiAutomator
        val list = device.findObject(By.scrollable(true))
        list.scroll(Direction.DOWN, 5.0f)

    }
}
